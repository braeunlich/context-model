package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

/**
 * This {@link Event} will be fired whenever a {@link JavaClass} is selected or
 * brought to top in an JavaEditor.
 * 
 * @author chb
 * 
 */
public class JavaClassSelectedEvent implements JavaElementSelectedEvent {

	private final JavaClass clazz;

	public JavaClassSelectedEvent(JavaClass clazz) {
		this.clazz = clazz;
	}

	@Override
	public JavaElement getAffectedJavaElement() {
		return clazz;
	}

}
