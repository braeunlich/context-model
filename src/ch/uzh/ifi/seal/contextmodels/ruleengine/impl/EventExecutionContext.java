package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import java.util.List;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.EventHandler;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class EventExecutionContext implements ExecutionContext {

	private Class<? extends Event> eventType;
	private boolean affectsAllElements = false;
	
	
	private List<? extends JavaElement> overwrittenAffectedElements = null;

	public EventExecutionContext(Class<? extends Event> eventType) {
		this.eventType = eventType;
	}

	@Override
	public void execute(final Task task) {

		EventBus.get().registerEventHandler(new EventHandler() {

			@Override
			public void onEvent(Event event) {
				if(affectsAllElements) {
					overwrittenAffectedElements = ContextModel.get().getAllJavaElements();
				}
				
				if (overwrittenAffectedElements == null) {
					task.run(event.getAffectedJavaElement());
				} else {
					for (JavaElement element : overwrittenAffectedElements) {
						task.run(element);
					}
				}
			}

			@Override
			public Class<? extends Event> getEventType() {
				return eventType;
			}
		});

	}

	@Override
	public void overwriteAffectedElements(
			List<? extends JavaElement> affectedElements) {
		overwrittenAffectedElements = affectedElements;
	}

	@Override
	public void setAffectsAllElements() {
		affectsAllElements = true;
	}

}
