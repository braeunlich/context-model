package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.view.ImageFactory;

public class CallerFigure extends Figure {

	private static Color callerColor = new Color(null, 153, 204, 255);
	private CompartmentFigure callerCompartment = new CompartmentFigure();
	
	private final JavaMethod calee;
	
	public CallerFigure(JavaMethod calee) {
		this.calee = calee;
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(callerColor);
		setOpaque(true);
		
		add(getClassLabel("Methods that call " + calee.getName()));
		
		add(callerCompartment);
		
		addCallers();
	}
	
	private Label getClassLabel(String text) {
		Font classFont = new Font(null, "Arial", 9, SWT.BOLD);
		Image image = ImageFactory.getImage(calee.getJdtMethod());

		Label classLabel = new Label(text, image);
		classLabel.setFont(classFont);
		
		MarginBorder border = new MarginBorder(4, 0, 0, 0);
		classLabel.setBorder(border);
		
		return classLabel;
	}
	
	private void addCallers() {
		for(final JavaMethod caller: ContextModel.get().getCallers(calee)){
			callerCompartment.add(new MethodLabel(caller));
		}
	}
	
}
