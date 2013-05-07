package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.swt.SWT;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.IContainer;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;

public class ClassGraphNode extends CGraphNode {

	private final JavaClass clazz;
	
	public ClassGraphNode(IContainer graphModel, JavaClass clazz) {
		super(graphModel, SWT.NONE, new ClassFigure(clazz));
		this.clazz = clazz;
	}
	
	public JavaClass getJavaClass() {
		return clazz;
	}

}
