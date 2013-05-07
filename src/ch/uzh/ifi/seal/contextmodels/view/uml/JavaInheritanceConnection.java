package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

public final class JavaInheritanceConnection extends JavaRelationConnection {

	public JavaInheritanceConnection(Graph graphModel, GraphNode parent,
			GraphNode child) {

		super(graphModel, ZestStyles.CONNECTIONS_DIRECTED, child, parent);
		
		setLineWidth(2);
		
	}

	protected PolygonDecoration getSourceDecoration() {
		return ConnectionDecoration.arrow(getLineWidth());
	}

	protected PolygonDecoration getTargetDecoration() {
		return ConnectionDecoration.empty(getLineWidth());
	}
	
}
