package ch.uzh.ifi.seal.contextmodels.eventmodel.events;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

/**
 * This {@link Event} will be fired whenever a {@link JavaClass} that previously wasn't open in a 
 * {@link org.eclipse.jdt.internal.ui.javaeditor.JavaEditor} is being opened.
 * 
 * If you are looking for an {@link Event} that is fired whenever a {@link JavaClass} is brought to top, 
 * check out {@link JavaClassSelectedEvent}.
 * 
 * @author chb
 *
 */
@SuppressWarnings("restriction")
public class JavaClassOpenedEvent implements Event {

	private JavaClass clazz;
	
	public JavaClassOpenedEvent(JavaClass clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public JavaElement getAffectedJavaElement() {
		return clazz;
	}

}
