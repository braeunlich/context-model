package ch.uzh.ifi.seal.contextmodels.ruleengine;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public interface RulesDsl {
	
	TimeUnit every(int number);
	JavaElementAction onEvent(Class<? extends Event> event);
	
	interface TimeUnit {
		JavaElementSelector miliseconds();
		JavaElementSelector seconds();
		JavaElementSelector minutes();
	}
	
	interface JavaElementSelector {
		JavaElementAction withJavaElement(JavaElement element);
		JavaElementAction forAllJavaElements();
	}
	
	interface JavaElementAction {
		void increaseRelevancyBy(double number);
		void setActive();
		void findStructuralDependencies();
		void log(String logMessage);
		JavaElementAction forAllJavaElements();
	}

}
