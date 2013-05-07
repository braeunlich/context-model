package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;

public class RefreshAction extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		JdtUtil.getContextModelDiagramView().refresh();
		return null;
	}

}
