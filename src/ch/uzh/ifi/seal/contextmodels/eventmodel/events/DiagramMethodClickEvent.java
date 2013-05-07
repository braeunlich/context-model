package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.DiagramClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class DiagramMethodClickEvent implements DiagramClickEvent {

	private final JavaMethod method;
	
	public DiagramMethodClickEvent(JavaMethod method) {
		this.method = method;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return method;
	}
	
}
