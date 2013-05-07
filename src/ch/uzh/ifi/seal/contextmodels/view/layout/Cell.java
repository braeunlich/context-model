package ch.uzh.ifi.seal.contextmodels.view.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import ch.uzh.ifi.seal.contextmodels.view.uml.ClassFigure;

public class Cell {

	private final CellLayout layout;
	private final CellCoordinate coordinates;

	private ClassFigure figure;

	public Cell(final CellLayout layout, final CellCoordinate coordinates) {
		this.coordinates = coordinates;
		this.layout = layout;
	}

	public Rectangle getBounds() {
		return layout.getCellBounds(coordinates);
	}

	public void addClassFigure(ClassFigure figure) {
		this.figure = figure;
		layout.getRootFigure().add(figure);
		layoutNode();
	}
	
	public void layoutNode() {
		layout.getSwtLayout().setConstraint(figure, getRectangle(figure));
	}

	/**
	 * Show the class in the center of the cell.
	 * 
	 * @param figure
	 * @return
	 */
	private Rectangle getRectangle(ClassFigure figure) {
		Rectangle bounds = getBounds();

		int width = figure.getPreferredSize().width;
		int height = figure.getPreferredSize().height;

		width = bounds.width < width ? bounds.width : width;
		height = bounds.height < height ? bounds.height : height;

		int x = bounds.x + (bounds.width - width) / 2;
		int y = bounds.y + (bounds.height - height) / 2;

		return new Rectangle(x, y, width, height);
	}

}
