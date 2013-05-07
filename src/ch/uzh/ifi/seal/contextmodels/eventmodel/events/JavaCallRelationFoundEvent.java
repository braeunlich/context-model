package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.AstAnalyzerEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.RelationalEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaCallRelation;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class JavaCallRelationFoundEvent implements RelationalEvent,
		AstAnalyzerEvent {

	private final JavaCallRelation relation;
	
	public JavaCallRelationFoundEvent(final JavaCallRelation relation) {
		this.relation = relation;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return relation;
	}

}
