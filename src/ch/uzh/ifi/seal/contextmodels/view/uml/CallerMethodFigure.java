package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class CallerMethodFigure extends Figure {
	
	public static final int HEIGHT = 18;
	
	private static Color callerColor = new Color(null, 153, 204, 255);
	private final MethodLabel methodLabel;
	
	public CallerMethodFigure(JavaMethod calee) {
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(callerColor);
		setOpaque(true);
		
		methodLabel = new MethodLabel(calee, true);
		
		add(methodLabel);
	}
	
	public MethodLabel getMethodLabel() {
		return methodLabel;
	}
	
}
