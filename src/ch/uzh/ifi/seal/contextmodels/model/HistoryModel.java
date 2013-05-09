package ch.uzh.ifi.seal.contextmodels.model;

import java.util.ArrayList;
import java.util.List;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.EventHandler;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public final class HistoryModel {
	
	private final static HistoryModel INSTANCE = new HistoryModel();
	private final EventBus bus = EventBus.get();
	private final List<JavaElement> navigationHistory = new ArrayList<>();
	
	private HistoryModel() {
		bus.registerEventHandler(new EventHandler() {

			@Override
			public void onEvent(Event event) {
				JavaElement element = event.getAffectedJavaElement();
				if(getLastElement() == null || !getLastElement().equals(element)) {
					navigationHistory.add(element);
				}
			}

			@Override
			public Class<? extends Event> getEventType() {
				return JavaElementSelectedEvent.class;
			}
			
			
		});
	}
	
	public static HistoryModel getInstance() {
		return INSTANCE;
	}

	public JavaElement getLastElement() {
		if(navigationHistory.size()==0) {
			return null;
		}
		return navigationHistory.get(navigationHistory.size()-1);
	}
	
	public JavaMethod getLastMethod() {
		for(int i=navigationHistory.size()-1; i>=0; i--) {
			if(navigationHistory.get(i) instanceof JavaMethod) {
				return (JavaMethod)navigationHistory.get(i);
			}
		}
		return null;
	}
	
	public JavaMethod getMethod(int indexFromBack) {
		
		System.out.println("=== get element " + indexFromBack);
		
		
		for(JavaElement element : navigationHistory) {
			System.out.println(element);
		}
		
		
		for(int i=navigationHistory.size()-1; i>=0; i--) {
			if(navigationHistory.get(i) instanceof JavaMethod) {
				if(indexFromBack == 0) {
					System.out.println("==> " + navigationHistory.get(i));
					return (JavaMethod)navigationHistory.get(i);
				}
				indexFromBack--;
			}
		}
		return null;
	}
	
}
