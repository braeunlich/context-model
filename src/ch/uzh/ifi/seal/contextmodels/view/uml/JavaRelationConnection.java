package ch.uzh.ifi.seal.contextmodels.view.uml;

import java.lang.reflect.Field;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.internal.PolylineArcConnection;

import ch.uzh.ifi.seal.contextmodels.util.Logger;

@SuppressWarnings("restriction")
public abstract class JavaRelationConnection extends GraphConnection {

	protected PolylineArcConnection connection;

	public JavaRelationConnection(Graph graphModel, int style,
			GraphNode source, GraphNode destination) {
		super(graphModel, style, source, destination);

		try {
			Field field = getClass().getSuperclass().getSuperclass().getDeclaredField(
					"connectionFigure");
			field.setAccessible(true);
			connection = (PolylineArcConnection) field.get(this);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			Logger.error("Could not access connectionFigure! " + e.getMessage());
		}

		decorateConnection();
	}

	public JavaRelationConnection(Graph graphModel, GraphNode source,
			GraphNode destination) {
		this(graphModel, SWT.NONE, source, destination);
	}

	public void setRelevance(double relevance) {
		// int lineWidth = ((int) log1p(relevance)) + 1;
		// setLineWidth(lineWidth);
	}

	protected void decorateConnection() {
		connection.setTargetDecoration(getTargetDecoration());
		connection.setSourceDecoration(getSourceDecoration());
	}

	protected abstract PolygonDecoration getSourceDecoration();

	protected abstract PolygonDecoration getTargetDecoration();

	@Override
	public void setText(String string) {
		super.setText(string);
		decorateConnection();
	}

	@Override
	public void highlight() {
		super.highlight();
		decorateConnection();
	}

	@Override
	public void unhighlight() {
		super.unhighlight();
		decorateConnection();
	}

	@Override
	public void setConnectionStyle(int style) {
		super.setConnectionStyle(style);
		decorateConnection();
	}

	@Override
	public void setCurveDepth(int depth) {
		super.setCurveDepth(depth);
		decorateConnection();
	}

	@Override
	public void setLineStyle(int lineStyle) {
		super.setLineStyle(lineStyle);
		decorateConnection();
	}

	@Override
	public void setLineWidth(int lineWidth) {
		super.setLineWidth(lineWidth);
		decorateConnection();
	}

	@Override
	public void setTooltip(IFigure tooltip) {
		super.setTooltip(tooltip);
		decorateConnection();
	}

}
