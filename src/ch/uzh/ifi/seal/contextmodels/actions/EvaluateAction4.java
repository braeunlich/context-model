package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import ch.uzh.ifi.seal.contextmodels.evaluation.Transcript24;

public class EvaluateAction4 extends AbstractHandler {

private Transcript24 transcript;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(transcript == null) {
			transcript = new Transcript24();
			transcript.prepare();
		}
		transcript.run();
		return null;
	}
}
