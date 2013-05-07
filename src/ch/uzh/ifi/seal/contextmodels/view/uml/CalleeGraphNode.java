package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.swt.SWT;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.IContainer;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class CalleeGraphNode extends CGraphNode {

	public CalleeGraphNode(IContainer graphModel, JavaMethod method) {
		super(graphModel, SWT.NONE, new CalleeFigure(method));
	}

}
