package ch.uzh.ifi.seal.contextmodels.eventmodel;

import java.util.ArrayList;
import java.util.List;

import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassScrollEvent;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public final class EventBus {

	private EventBus() {
	}

	private static EventBus instance;

	private Event lastEvent = null;
	
	private List<Class<? extends Event>> canHappenMultipleTimes = new ArrayList<>();

	private void fillEventsThatCanHappenMultipleTimes() {
		canHappenMultipleTimes.add(JavaClassKeyPressEvent.class);
		canHappenMultipleTimes.add(JavaClassScrollEvent.class);
	}
	
	/**
	 * Get The single instance of the EventBus.
	 * 
	 * @return
	 */
	public static EventBus get() {
		if (instance == null) {
			instance = new EventBus();
			instance.fillEventsThatCanHappenMultipleTimes();
		}
		return instance;
	}

	private List<EventHandler> eventHandlers = new ArrayList<>();

	/**
	 * Register an {@link EventHandler} to the EventBus.
	 * 
	 * @param handler
	 */
	public void registerEventHandler(EventHandler handler) {
		eventHandlers.add(handler);
	}

	/**
	 * Notify all {@link EventHandler}s which are listening for events of the
	 * same type or a sub type of {@code event}.
	 * 
	 * @param event
	 */
	public void fireEvent(Event event) {
		if (!(event == null || event.getAffectedJavaElement() == null || sameAsLastEvent(event))) {
			for (EventHandler handler : eventHandlers) {
				if (handler.getEventType().isAssignableFrom(event.getClass())) {
					handler.onEvent(event);
				}
			}
		}
		lastEvent = event;
	}

	private boolean sameAsLastEvent(Event event) {
		if (lastEvent == null) {
			return false;
		}
		
		if(canHappenMultipleTimes.contains(event.getClass())) {
			return false;
		}

		if (event.getAffectedJavaElement().equals(
				lastEvent.getAffectedJavaElement())
				&& event.getClass().equals(lastEvent.getClass())) {
			Logger.info("The same Event occured before - the event will not be forwarded");
			return true;
		}

		return false;

	}

}
