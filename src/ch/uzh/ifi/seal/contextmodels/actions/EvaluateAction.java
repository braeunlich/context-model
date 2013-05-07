package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ch.uzh.ifi.seal.contextmodels.evaluation.Transcript09;

public class EvaluateAction extends AbstractHandler {

	private Transcript09 transcript;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(transcript == null) {
			transcript = new Transcript09();
			transcript.prepare();
		}
		transcript.run();
		return null;
	}

}
