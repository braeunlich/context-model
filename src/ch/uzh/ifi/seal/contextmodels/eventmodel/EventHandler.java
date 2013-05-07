package ch.uzh.ifi.seal.contextmodels.eventmodel;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;

/**
 * Handle Events of a specific type.
 * 
 * @author Christoph Braeunlich
 *
 */
public interface EventHandler {

	/**
	 * This method will be called if the event handler is registered to a {@link EventBus}
	 * And a sub type T of {@link Event} is fired.
	 * 
	 * @param event The fired {@link Event}.
	 */
	void onEvent(Event event);
	
	/**
	 * The EventHandler will be notified in case of {@link Event}s of 
	 * the same Type or SubTypes.
	 * 
	 * @return Type of events to handle. 
	 */
	Class<? extends Event> getEventType();
	
}
