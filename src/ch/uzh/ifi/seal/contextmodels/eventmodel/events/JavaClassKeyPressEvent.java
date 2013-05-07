package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class JavaClassKeyPressEvent implements Event{

	private final JavaClass clazz;
	
	public JavaClassKeyPressEvent(JavaClass clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return clazz;
	}

}
