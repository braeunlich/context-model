package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class JavaMethodSelectedEvent implements JavaElementSelectedEvent {

	private final JavaMethod method;
	
	public JavaMethodSelectedEvent(final JavaMethod method) {
		this.method = method;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return method;
	}

}
