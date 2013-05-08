package ch.uzh.ifi.seal.contextmodels.view.layout;

import org.eclipse.draw2d.geometry.Rectangle;

public abstract class Cell {

	protected final CellLayout layout;
	protected final CellCoordinate coordinates;

	public Cell(final CellLayout layout, final CellCoordinate coordinates) {
		this.coordinates = coordinates;
		this.layout = layout;
	}

	public Rectangle getBounds() {
		return layout.getCellBounds(coordinates);
	}

	
	/**
	 * reposition all elements of the cell.
	 */
	public abstract void layoutNode();

	/**
	 * Show the class in the center of the cell.
	 * 
	 * @param figure
	 * @return
	 */
	public abstract Rectangle getRectangle();

}
