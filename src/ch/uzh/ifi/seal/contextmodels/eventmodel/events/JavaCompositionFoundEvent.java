package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.AstAnalyzerEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.RelationalEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaComposition;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class JavaCompositionFoundEvent implements RelationalEvent, AstAnalyzerEvent {

	private final JavaComposition composition;
	
	public JavaCompositionFoundEvent(final JavaComposition composition) {
		this.composition = composition;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return composition;
	}

}
