package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.RelationalEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaRelation;

public class JavaInheritanceFoundEvent implements RelationalEvent {

	private final JavaRelation relation;
	
	public JavaInheritanceFoundEvent(JavaInheritance inheritance) {
		this.relation = inheritance;
	}

	@Override
	public JavaElement getAffectedJavaElement() {
		return relation;
	}

}
