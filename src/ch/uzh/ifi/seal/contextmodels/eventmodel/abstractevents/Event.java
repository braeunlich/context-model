package ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public interface Event {
	
	/**
	 * 
	 * @return The JavaEleent affected by the Action.
	 */
	JavaElement getAffectedJavaElement();
	
}
