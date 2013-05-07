package ch.uzh.ifi.seal.contextmodels.evaluation;

import java.util.ArrayList;
import java.util.List;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.EventHandler;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class NavigationHistory {

	final List<String> classNames = new ArrayList<>();
	final List<String> methodNames = new ArrayList<>();
	final List<String> fieldNames = new ArrayList<>();
	
	private boolean isRevisit = false;
	private boolean isRelevantInContextModel = false;
	
	String lastElement = "";
	
	EventBus bus = EventBus.get();
	
	public boolean isRelevantInContextModel() {
		boolean tmp = isRelevantInContextModel;
		isRelevantInContextModel = false;
		return tmp;
	}
	
	public boolean isRevisit() {
		boolean tmp = isRevisit;
		isRevisit = false;
		return tmp;
	}
	
	public NavigationHistory() {
		bus.registerEventHandler(new EventHandler() {
			
			@Override
			public void onEvent(Event event) {
				JavaElement element = ((JavaElementSelectedEvent)event).getAffectedJavaElement();
				if(element instanceof JavaClass) {
					handleClassNavigation((JavaClass)element);
				} else if(element instanceof JavaField) {
					handleFieldNavigation((JavaField)element);
				} else if(element instanceof JavaMethod) {
					handleMethodNavigation((JavaMethod)element);
				}
				
			}
			
			@Override
			public Class<? extends Event> getEventType() {
				return JavaElementSelectedEvent.class;
			}
		});
	}
	
	private void handleClassNavigation(JavaClass element) {
		String name = element.getFullyQualifiedName();
		isRevisit = classNames.contains(name);
		isRelevantInContextModel = element.isRelevant();
		classNames.add(name);
		lastElement = name;
	}
	
	private void handleMethodNavigation(JavaMethod element) {
		String name = element.getJavaClass().getFullyQualifiedName() + "." + element.getName();
		isRevisit = methodNames.contains(name);
		isRelevantInContextModel = element.isRelevant();
		methodNames.add(name);
		lastElement = name;
	}
	
	private void handleFieldNavigation(JavaField element) {
		String name = element.getJavaClass().getFullyQualifiedName() + "." + element.getName();
		isRevisit = fieldNames.contains(name);
		isRelevantInContextModel = element.isRelevant();
		fieldNames.add(name);
		lastElement = name;
	}
	
}
