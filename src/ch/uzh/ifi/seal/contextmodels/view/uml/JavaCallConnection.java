package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

public class JavaCallConnection extends JavaRelationConnection {

	public JavaCallConnection(Graph graphModel, GraphNode source,
			GraphNode destination) {
		super(graphModel, source, destination);
		setConnectionStyle(ZestStyles.CONNECTIONS_DOT);
	}

	@Override
	protected PolygonDecoration getSourceDecoration() {
		return ConnectionDecoration.empty(getLineWidth());
	}

	@Override
	protected PolygonDecoration getTargetDecoration() {
		return ConnectionDecoration.arrow(getLineWidth());
	}

}
