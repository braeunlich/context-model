package ch.uzh.ifi.seal.contextmodels.view.uml;

import java.text.DecimalFormat;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LabelAnchor;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jdt.core.Signature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.DiagramMethodClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;
import ch.uzh.ifi.seal.contextmodels.util.MouseAdapter;
import ch.uzh.ifi.seal.contextmodels.view.ImageFactory;

public class MethodLabel extends Label {
	
	private final static Font NORMAL_FONT = new Font(null, "Arial", 8, SWT.NORMAL);
	private final static Font IMPORTANT_FONT = new Font(null, "Arial", 8, SWT.BOLD);
	
	private boolean standalone = false;
	private final JavaMethod method;
	
	/**
	 * 
	 * @param method
	 * @param standalone Show the class name.
	 */
	public MethodLabel(final JavaMethod method, boolean standalone) {
		this.standalone = standalone;
		this.method = method;
		setLabel(method);
		setImage(method);
		addListener(method);
		setFont(method);
		setColor(method);
	}
	
	public MethodLabel(final JavaMethod method) {
		this(method, false);
	}
	
	public boolean isActive() {
		return method.isActive();
	}

	private void setColor(JavaMethod method) {
		if(method.isActive()) {
			setForegroundColor(ColorConstants.darkBlue);
		}
	}

	private void setImage(final JavaMethod method) {
		Image image = ImageFactory.getImage(method.getJdtMethod());
		setIcon(image);
	}

	private void setLabel(final JavaMethod method) {
		String labelString = method.getName() + "(): " + Signature.getSignatureSimpleName(method.getType()) + " (" + formatRelevance(method.getRelevance()) + ")";
		if(standalone) {
			labelString = method.getJavaClass().getName() + "::" + labelString;
		}
		
		if(method.isActive()) {
			labelString = ">> " + labelString + " <<";
		}
		setText(labelString);
	}

	private void addListener(final JavaMethod method) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				JdtUtil.openJavaElementInJavaEditor(method.getJdtMethod());
				EventBus.get().fireEvent(new DiagramMethodClickEvent(method));
			}
		});
	}

	private void setFont(final JavaMethod method) {
		if(method.isImportant() || method.isActive()) {
			setFont(IMPORTANT_FONT);
		} else {
			setFont(NORMAL_FONT);
		}
	}
	
	private String formatRelevance(double relevance) {
		DecimalFormat format = new DecimalFormat("#.##");
		return format.format(relevance);
	}
	
	public ConnectionAnchor getRightAnchor() {
		return new LabelAnchor(this) {
			@Override
			protected Rectangle getBox() {
				int x = getBounds().x + getBounds().width;
				int y = getBounds().y;
				int width = 0;
				int height = getBounds().height;
				
				return new Rectangle(x, y, width, height);
			}
		};
	}
	
	public ConnectionAnchor getLeftAnchor() {
		return new LabelAnchor(this) {
			@Override
			protected Rectangle getBox() {
				int x = getBounds().x;
				int y = getBounds().y;
				int width = 0;
				int height = getBounds().height;
				
				return new Rectangle(x, y, width, height);
			}
		};
	}

}
