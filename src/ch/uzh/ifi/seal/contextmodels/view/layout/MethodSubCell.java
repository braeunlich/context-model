package ch.uzh.ifi.seal.contextmodels.view.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import ch.uzh.ifi.seal.contextmodels.view.uml.MethodFigure;


public class MethodSubCell {
	
	private Rectangle bounds;
	private MethodFigure figure;
	private final CellLayout layout;

	public MethodSubCell(final CellLayout layout, final Rectangle bounds) {
		this.bounds = bounds;
		this.layout = layout;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void setMethodFigure(MethodFigure figure) {
		this.figure = figure;
		layout.getRootFigure().add(figure);
		layoutNode();
	}
	
	public void clearFigure() {
		layout.getRootFigure().remove(figure);
	}
	
	public void layoutNode() {
		if(figure == null) {
			return;
		}
		layout.getSwtLayout().setConstraint(figure, getRectangle());
	}

	private Rectangle getRectangle() {
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
