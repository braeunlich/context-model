package ch.uzh.ifi.seal.contextmodels.view.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.view.uml.ClassFigure;
import ch.uzh.ifi.seal.contextmodels.view.uml.MethodLabel;

/**
 * Large Layout
 * 
 * Number of elements depends on the size of the view (3x3, 3x5, 5x3 or 5x5
 * cells).
 * 
 * The coordinates (0,0) always denote the center cell.
 * 
 * 
 * @author chb
 * 
 */
public class CellLayout {

	// Margin between Cells
	private final static int CELL_MARGIN = 10;
	// Thresholds: if the view's size is larger than a threshold,
	// 5 instead of three cells are displayed.
	private final static int THRESHOLD_WIDTH = 500;
	private final static int THRESHOLD_HEIGHT = 500;

	private final Composite parent;

	private int numberOfCellsX = 3;
	private int numberOfCellsY = 3;

	Map<CellCoordinate, Cell> cells = new HashMap<>();

	private final Figure rootFigure;
	private final XYLayout swtLayout;
	
	private ClassFigure activeClassFigure;

	public CellLayout(final Composite parent, final Figure rootFigure,
			XYLayout swtLayout) {
		this.parent = parent;
		this.rootFigure = rootFigure;
		this.swtLayout = swtLayout;

		parent.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				resize();
			}
		});
	}

	private void resize() {
		calculateNumberOfCells();
	}

	public void reset() {
		rootFigure.removeAll();
		cells.clear();
	}

	private void calculateNumberOfCells() {
		numberOfCellsX = parent.getBounds().width > THRESHOLD_WIDTH ? 5 : 3;
		numberOfCellsY = parent.getBounds().height > THRESHOLD_HEIGHT ? 5 : 3;
	}

	public void addActiveClass(CellCoordinate coordinate, JavaClass clazz) {
		activeClassFigure = addClass(coordinate, clazz);
	}
	
	public ClassFigure getActiveClassFigure() {
		return activeClassFigure;
	}
	
	public ClassFigure addClass(CellCoordinate coordinate, JavaClass clazz) {
		if (!checkBounds(coordinate)) {
			return null;
		}
		
		Cell cell = getClassCell(coordinate);
		
		if(cell == null || !(cell instanceof ClassCell)) {
			return null;
		}
		ClassFigure classFigure = new ClassFigure(clazz);
		((ClassCell)cell).addClassFigure(classFigure);
		
		return classFigure;
	}

	/**
	 * Return the cell at the given coordinates or create the cell.
	 * 
	 * </br></br>
	 * 
	 * If the coordinate is not available in the current layout, an
	 * IndexOutOfBoundsException will be thrown.
	 * 
	 * @param x
	 *            X-Coordinate of the cell
	 * @param y
	 *            Y-Coordinate of the cell
	 * @return
	 */
	public Cell getCell(CellCoordinate coordinate) {
		if (!checkBounds(coordinate)) {
			return null;
		}

		if (cells.containsKey(coordinate)) {
			return cells.get(coordinate);
		}
		
		return null;
	}

	public ClassCell getClassCell(CellCoordinate coordinate) {
		Cell cell = getCell(coordinate); 
		
		if(cell == null) {
			cell = new ClassCell(this, coordinate);
			cells.put(coordinate, cell);
		} 
		
		if(!(cell instanceof ClassCell)) {
			return null;
		}
		
		return (ClassCell)cell;
	}
	
	public MethodCell getMethodCell(CellCoordinate coordinate) {
		Cell cell = getCell(coordinate); 
		
		if(cell == null) {
			cell = new MethodCell(this, coordinate);
			cells.put(coordinate, cell);
		} 
		
		if(!(cell instanceof MethodCell)) {
			return null;
		}
		
		return (MethodCell)cell;
	}
	
	/**
	 * Get a rectangle that denotes the maximum size (and position) that content
	 * content of a cell can use.
	 * 
	 * @param coordinate
	 * @return
	 */
	public Rectangle getCellBounds(CellCoordinate coordinate) {

		if (!checkBounds(coordinate)) {
			throw new IndexOutOfBoundsException();
		}

		int xCellNumber = coordinate.getX() + numberOfCellsX / 2;
		int xPos = CELL_MARGIN * (xCellNumber + 1) + xCellNumber
				* getCellWidth();

		int yCellNumber = coordinate.getY() + numberOfCellsY / 2;
		int yPos = CELL_MARGIN * (yCellNumber + 1) + yCellNumber
				* getCellHeight();

		return new Rectangle(xPos, yPos, getCellWidth(), getCellHeight());
	}

	/**
	 * Determines whether two cells can be connected. Cells cannot be connected
	 * if the connection would cross a third cell.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean canBeConnected(CellCoordinate a, CellCoordinate b) {
		if (Math.abs(a.getX() - b.getX()) <= 1
				&& Math.abs(a.getY() - b.getY()) <= 1) {
			return true;
		}
		return false;
	}

	/**
	 * Priorities are as follows:<br />
	 * 
	 * <pre>
	 * [parent 4] [parent 2] [parent 1] [parent 3] [parent 5] <br />
	 * .......................[ cell ]....................... <br />
	 * [child  4] [child  2] [child  1] [child  3] [child  5] <br />
	 * </pre>
	 * 
	 * @param cell
	 * @return free coordinates of a cell that is above "cell".
	 */
	public CellCoordinate getFreeParentCoordinates(CellCoordinate cell) {
		List<CellCoordinate> coordinatePriorities = new ArrayList<>();

		coordinatePriorities.add(new CellCoordinate(cell.getX(),
				cell.getY() - 1));

		for (int i = 1; i <= numberOfCellsX / 2; i++) {
			coordinatePriorities.add(new CellCoordinate(cell.getX() - i, cell
					.getY() - 1));
			coordinatePriorities.add(new CellCoordinate(cell.getX() + i, cell
					.getY() - 1));
		}

		return getFirstFreeCoordinate(coordinatePriorities);
	}

	/**
	 * Priorities are as follows:<br />
	 * 
	 * <pre>
	 * [parent 4] [parent 2] [parent 1] [parent 3] [parent 5] <br />
	 * .......................[ cell ]....................... <br />
	 * [child  4] [child  2] [child  1] [child  3] [child  5] <br />
	 * </pre>
	 * 
	 * @param cell
	 * @return free coordinates of a cell that is above "cell".
	 */
	public CellCoordinate getFreeChildCoordinates(CellCoordinate cell) {
		List<CellCoordinate> coordinatePriorities = new ArrayList<>();

		coordinatePriorities.add(new CellCoordinate(cell.getX(),
				cell.getY() + 1));

		for (int i = 0; i < numberOfCellsX / 2; i++) {
			coordinatePriorities.add(new CellCoordinate(cell.getX() - i, cell
					.getY() + 1));
			coordinatePriorities.add(new CellCoordinate(cell.getX() + i, cell
					.getY() + 1));
		}

		return getFirstFreeCoordinate(coordinatePriorities);
	}

	public CellCoordinate getFreeCallerCoordinate(CellCoordinate cell) {
		List<CellCoordinate> coordinatePriorities = new ArrayList<>();

		coordinatePriorities.add(new CellCoordinate(cell.getX() - 1, cell.getY()));
		coordinatePriorities.add(new CellCoordinate(cell.getX() - 1, cell.getY() + 1));
		coordinatePriorities.add(new CellCoordinate(cell.getX() - 1, cell.getY() - 1));
		
		return getFirstFreeCoordinate(coordinatePriorities);
	}
	
	public CellCoordinate getFreeCalleeCoordinate(CellCoordinate cell) {
		List<CellCoordinate> coordinatePriorities = new ArrayList<>();

		coordinatePriorities.add(new CellCoordinate(cell.getX() + 1, cell.getY()));
		coordinatePriorities.add(new CellCoordinate(cell.getX() + 1, cell.getY() + 1));
		coordinatePriorities.add(new CellCoordinate(cell.getX() + 1, cell.getY() - 1));
		
		return getFirstFreeCoordinate(coordinatePriorities);
	}
	
	private CellCoordinate getFirstFreeCoordinate(
			List<CellCoordinate> coordinateList) {
		for (CellCoordinate coordinates : coordinateList) {
			if (!cells.containsKey(coordinates) && checkBounds(coordinates)) {
				return coordinates;
			}
		}
		return null;
	}

	private int getCellWidth() {
		int width = parent.getBounds().width - CELL_MARGIN
				* (numberOfCellsX + 1);
		return width / numberOfCellsX;
	}

	private int getCellHeight() {
		int height = parent.getBounds().height - CELL_MARGIN
				* (numberOfCellsY + 1);
		return height / numberOfCellsY;
	}

	private boolean checkBounds(CellCoordinate coordinate) {
		if (Math.abs(coordinate.getX()) > (numberOfCellsX / 2)
				|| Math.abs(coordinate.getY()) > (numberOfCellsY / 2)) {
			return false;
		}
		return true;
	}

	public Figure getRootFigure() {
		return rootFigure;
	}

	public XYLayout getSwtLayout() {
		return swtLayout;
	}

	public void addInheritance(CellCoordinate childCoordinate,
			CellCoordinate parentCoordinate) {
		
		ClassCell childCell = getClassCell(childCoordinate); 
		ClassCell parentCell = getClassCell(parentCoordinate); 

		if(childCell == null || parentCell == null) {
			return;
		}
		
		ClassFigure childClassFigure = ((ClassCell)childCell).getClassFigure();
		ClassFigure parentClassFigure = ((ClassCell)parentCell).getClassFigure();

		if (childClassFigure == null || parentClassFigure == null) {
			return;
		}

		rootFigure.add(parentClassFigure);
		swtLayout.setConstraint(parentClassFigure, getCell(parentCoordinate)
				.getRectangle());
		rootFigure.add(connectInheritance(childClassFigure, parentClassFigure));

	}
	
	public void addCall(MethodLabel caller, MethodLabel calee) {
		rootFigure.add(connectCaller(caller, calee));
	}
	
	private PolylineConnection connectCaller(MethodLabel caller,
			MethodLabel calee) {
		PolylineConnection connection = new PolylineConnection();
		connection.setSourceAnchor(caller.getRightAnchor());
		connection.setTargetAnchor(calee.getLeftAnchor());
		return connection;
	}

	private PolylineConnection connectInheritance(ClassFigure child,
			ClassFigure parent) {
		PolylineConnection connection = new PolylineConnection();
		connection.setSourceAnchor(new ChopboxAnchor(child));
		connection.setTargetAnchor(new ChopboxAnchor(parent));

		PolygonDecoration decoration = new PolygonDecoration();
		decoration.setFill(true);
		decoration.setBackgroundColor(new Color(Display.getCurrent(), 255, 255,
				255));
		decoration.setScale(8, 6);
		connection.setTargetDecoration(decoration);

		return connection;
	}

}
