package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.DiagramClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class DiagramClassClickEvent implements DiagramClickEvent {

private JavaClass clazz;
	
	public DiagramClassClickEvent(JavaClass clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return clazz;
	}

}
