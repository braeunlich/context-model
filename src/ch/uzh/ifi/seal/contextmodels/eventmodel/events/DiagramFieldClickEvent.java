package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.DiagramClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;

public class DiagramFieldClickEvent implements DiagramClickEvent {

	private final JavaField field;
	
	public DiagramFieldClickEvent(JavaField field) {
		this.field = field;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return field;
	}
	
}
