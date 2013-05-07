package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;

public class JavaFieldSelectedEvent implements JavaElementSelectedEvent {

	private final JavaField field;
	
	public JavaFieldSelectedEvent(final JavaField field) {
		this.field = field;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return field;
	}

}
