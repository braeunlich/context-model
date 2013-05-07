package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;


public final class JavaCompositionConnection extends JavaRelationConnection {

	private final JavaField field;
	
	public JavaCompositionConnection(Graph graphModel, GraphNode source,
			GraphNode destination, JavaField field) {
		super(graphModel, source, destination);
		this.field = field;
	}
	
	protected PolygonDecoration getSourceDecoration() {
		return ConnectionDecoration.diamond(getLineWidth());
	}

	protected PolygonDecoration getTargetDecoration() {
		return ConnectionDecoration.empty(getLineWidth());
	}
	
	public JavaField getField() {
		return field;
	}
}
