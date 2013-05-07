package ch.uzh.ifi.seal.contextmodels.view.uml;


import java.text.DecimalFormat;

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

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.view.ImageFactory;

public class ClassFigure extends Figure {

	private static Color classColor = new Color(null, 255, 255, 206);
	private CompartmentFigure fieldFigure = new CompartmentFigure();
	private CompartmentFigure methodFigure = new CompartmentFigure();
	
	private JavaClass clazz;
	
	private MethodLabel activeMothodLabel = null;
	
	public ClassFigure(JavaClass clazz) {
		this.clazz = clazz;
		
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(classColor);
		setOpaque(true);
		
		add(getClassLabel(clazz.getName() + " (" + formatRelevance(clazz.getRelevance()) + ")"));
		
		add(fieldFigure);
		add(methodFigure);
		
		addFields();
		addMethods();
	}
	
	public MethodLabel getActiveMethodLabel() {
		return activeMothodLabel;
	}
	
	private Label getClassLabel(String text) {
		Font classFont = new Font(null, "Arial", 9, SWT.BOLD);
		Image image = ImageFactory.getImage(clazz.getJdtType());

		Label classLabel = new Label(text, image);
		classLabel.setFont(classFont);
		
		MarginBorder border = new MarginBorder(4, 0, 0, 0);
		classLabel.setBorder(border);
		
		return classLabel;
	}
	
	private void addFields() {
		for(final JavaField field: clazz.getFields()) {
			if(!field.isRelevant()) {
				continue;
			}
			fieldFigure.add(new FieldLabel(field));
		}
	}
	
	private void addMethods() {
		for(final JavaMethod method: clazz.getMethods()) {
			if(!method.isRelevant()) {
				continue;
			}
			MethodLabel label = new MethodLabel(method);
			if(label.isActive()) {
				activeMothodLabel = label;
			}
			methodFigure.add(label);
		}
	}
	
	private String formatRelevance(double relevance) {
		DecimalFormat format = new DecimalFormat("#.##");
		return format.format(relevance);
	}
	
}
