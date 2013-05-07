package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;

public class ActiveElementBorder extends AbstractBorder {

	@Override
	public Insets getInsets(IFigure figure) {
		return new Insets(1, 1, 1, 1);
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(),
				tempRect.getTopRight());
	}

}
