package ch.uzh.ifi.seal.contextmodels.view.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import ch.uzh.ifi.seal.contextmodels.view.uml.ClassFigure;

public class ClassCell extends Cell {

	private ClassFigure figure;

	public ClassCell(CellLayout layout, CellCoordinate coordinates) {
		super(layout, coordinates);
	}
	
	public void addClassFigure(ClassFigure figure) {
		this.figure = figure;
		layout.getRootFigure().add(figure);
		layoutNode();
	}
	
	public ClassFigure getClassFigure() {
		return figure;
	}
	
	@Override
	public Rectangle getRectangle() {
		Rectangle bounds = getBounds();

		int width = figure.getPreferredSize().width;
		int height = figure.getPreferredSize().height;

		width = bounds.width < width ? bounds.width : width;
		height = bounds.height < height ? bounds.height : height;

		int x = bounds.x + (bounds.width - width) / 2;
		int y = bounds.y + (bounds.height - height) / 2;

		return new Rectangle(x, y, width, height);
	}
	
	@Override
	public void layoutNode() {
		layout.getSwtLayout().setConstraint(figure, getRectangle());
	}
	
}
