package ch.uzh.ifi.seal.contextmodels.view.layout;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.view.uml.ClassFigure;

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
	private final static int RELAYOUT_THRESHOLD_WIDTH = 500;
	private final static int RELAYOUT_THRESHOLD_HEIGHT = 500;

	private final Composite parent;

	private int numberOfCellsX = 3;
	private int numberOfCellsY = 3;

	Map<CellCoordinate, Cell> cells = new HashMap<>();
	
	private final Figure rootFigure;
	private final XYLayout swtLayout;

	public CellLayout(final Composite parent, final Figure rootFigure, XYLayout swtLayout) {
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
		
		for(Cell cell: cells.values()) {
			cell.layoutNode();
		}
	}
	
	public void reset() {
		rootFigure.removeAll();
		cells.clear();
	}

	private void calculateNumberOfCells() {
		numberOfCellsX = parent.getBounds().width > RELAYOUT_THRESHOLD_WIDTH ? 5
				: 3;
		numberOfCellsY = parent.getBounds().height > RELAYOUT_THRESHOLD_HEIGHT ? 5
				: 3;
	}

	public void addClass(final int x, final int y, JavaClass clazz) {
		ClassFigure classFigure = new ClassFigure(clazz);
		getCell(x, y).addClassFigure(classFigure);
	}
	
	/**
	 * Return the cell at the given coordinates or create the cell.
	 * 
	 * </br></br>
	 * 
	 * If the coordinate is not available in the current layout, an
	 * IndexOutOfBoundsException will be thrown.
	 * 
	 * @param x X-Coordinate of the cell
	 * @param y Y-Coordinate of the cell
	 * @return
	 */
	public Cell getCell(final int x, final int y) {
		checkBounds(x, y);

		CellCoordinate coordinate = new CellCoordinate(x, y);
		if (cells.containsKey(coordinate)) {
			return cells.get(coordinate);
		}

		Cell cell = new Cell(this, coordinate);
		cells.put(coordinate, cell);
		return cell;
	}

	public Rectangle getCellBounds(CellCoordinate coordinates) {
		return getCellBounds(coordinates.getX(), coordinates.getY());
	}

	public Rectangle getCellBounds(final int x, final int y) {
		checkBounds(x, y);

		int xCellNumber = x + numberOfCellsX / 2;
		int xPos = CELL_MARGIN * (xCellNumber + 1) + xCellNumber
				* getCellWidth();

		int yCellNumber = x + numberOfCellsY / 2;
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

	private void checkBounds(final int x, final int y)
			throws IndexOutOfBoundsException {
		if (Math.abs(x) > (numberOfCellsX / 2)
				|| Math.abs(y) > (numberOfCellsY / 2)) {
			String message = "there is no cell with coordinates(" + x + "; "
					+ y + ")! " + "Available range: " + "("
					+ (numberOfCellsX / 2) * -1 + "; " + (numberOfCellsY / 2)
					* -1 + ") - " + "(" + (numberOfCellsX / 2) + "; "
					+ (numberOfCellsY / 2) * -1 + ")";
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	public Figure getRootFigure() {
		return rootFigure;
	}
	
	public XYLayout getSwtLayout() {
		return swtLayout;
	}

}
