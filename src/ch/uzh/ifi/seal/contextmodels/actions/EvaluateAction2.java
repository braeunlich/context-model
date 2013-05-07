package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ch.uzh.ifi.seal.contextmodels.evaluation.Transcript20;

public class EvaluateAction2 extends AbstractHandler {

private Transcript20 transcript;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(transcript == null) {
			transcript = new Transcript20();
			transcript.prepare();
		}
		transcript.run();
		return null;
	}

}
