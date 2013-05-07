package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;

public class AddToDiagramAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getActiveMenuSelection(event);
		
		Object element = selection.getFirstElement();
		if (element instanceof ICompilationUnit) {
			addCompilationUnit((ICompilationUnit) element);
		}
		
		return null;
	}

	private void addCompilationUnit(ICompilationUnit unit) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaClass clazz = model.getJavaClassFromCompilationUnit(unit);
		
		if (clazz != null) {
			ContextModel.get().addJavaClass(clazz);
		}
	}

}
