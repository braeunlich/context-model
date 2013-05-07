package ch.uzh.ifi.seal.contextmodels.view.uml;

import java.text.DecimalFormat;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.jdt.core.Signature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.DiagramFieldClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;
import ch.uzh.ifi.seal.contextmodels.util.MouseAdapter;
import ch.uzh.ifi.seal.contextmodels.view.ImageFactory;

public class FieldLabel extends Label {

	private final static Font NORMAL_FONT = new Font(null, "Arial", 8,
			SWT.NORMAL);
	private final static Font IMPORTANT_FONT = new Font(null, "Arial", 8,
			SWT.BOLD);

	public FieldLabel(final JavaField field) {
		setLabel(field);
		setImage(field);
		addListener(field);
		setFont(field);
		setColor(field);
	}

	private void setColor(JavaField field) {
		if (field.isActive()) {
			setBackgroundColor(ColorConstants.darkBlue);
		}
	}

	private void setLabel(final JavaField field) {
		String labelString = field.getName() + ": "
				+ Signature.getSignatureSimpleName(field.getType()) + " ("
				+ formatRelevance(field.getRelevance()) + ")";
		if (field.isActive()) {
			labelString = ">> " + labelString + " <<";
		}
		setText(labelString);
	}

	private void setImage(final JavaField field) {
		Image image = ImageFactory.getImage(field.getJdtField());
		setIcon(image);
	}

	private void addListener(final JavaField field) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				JdtUtil.openJavaElementInJavaEditor(field.getJdtField());
				EventBus.get().fireEvent(new DiagramFieldClickEvent(field));
			}
		});
	}

	private void setFont(final JavaField field) {
		if (field.isImportant() || field.isActive()) {
			setFont(IMPORTANT_FONT);
		} else {
			setFont(NORMAL_FONT);
		}
	}

	private String formatRelevance(double relevance) {
		DecimalFormat format = new DecimalFormat("#.##");
		return format.format(relevance);
	}

}
