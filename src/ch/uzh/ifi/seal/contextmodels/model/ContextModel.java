package ch.uzh.ifi.seal.contextmodels.model;

import static ch.uzh.ifi.seal.contextmodels.util.Util.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.JavaModelException;

import ch.uzh.ifi.seal.contextmodels.astanalyzer.MethodAnalyzer;
import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaCallRelationFoundEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassAddedToModelEvent;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaCallRelation;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaComposition;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaRelation;

/**
 * The ContextModel class stores a list of classes and relations. Displays of the ContextModels can 
 * be notified of changes by registering them as {@link Observer}.
 * 
 * ContextModel is a Singleton.
 * 
 * @author Christoph Braeunlich
 *
 */
public final class ContextModel extends Observable<ContextModel> {
	
	private static ContextModel instance;

	// Events are executed asynchronously therefore a concurrent access of the lists is possible.
	private final List<JavaClass> classes = Collections.synchronizedList(new ArrayList<JavaClass>());
	private final List<JavaRelation> relations = Collections.synchronizedList(new ArrayList<JavaRelation>());
	
	private JavaElement activeElement;
	
	/**
	 * 
	 * @return the only instance of ContextModel
	 */
	public static ContextModel get() {
		if(instance == null) {
			instance = new ContextModel();
		}
		return instance;
	}
	
	private ContextModel() {
	}
	
	/**
	 * 
	 * @return the complete list of classes in the model
	 */
	public List<JavaClass> getClasses() {
		return classes;
	}
	
	/**
	 * returns a complete list of all classes, methods and fields in the model.
	 * @return
	 */
	public List<JavaElement> getAllJavaElements() {
		List<JavaElement> elements = new ArrayList<>();
		elements.addAll(classes);
		for(JavaClass clazz: classes) {
			elements.addAll(clazz.getFields());
			elements.addAll(clazz.getMethods());
		}
		return elements;
	}
	
	/**
	 * 
	 * 
	 * @return a list of classes whose relevancy is higher than the relevancyThreshold.
	 */
	public List<JavaClass> getRelevantClasses() {
		List<JavaClass> relevantClasses = new ArrayList<>();
		for(JavaClass clazz: getClasses()) {
			if(clazz.isRelevant()) {
				relevantClasses.add(clazz);
			}
		}
		return relevantClasses;
	}
	
	/**
	 * 
	 * 
	 * @return a list of relations whose relevancy is higher than the relevancyThreshold.
	 */
	public List<JavaRelation> getRelevantRelations() {
		List<JavaRelation> relevantRelations = new ArrayList<>();
		for(JavaRelation relation: getRelations()) {
			if(relation.isRelevant()) {
				relevantRelations.add(relation);
			}
		}
		return favourInheritanceOverCopmosition(relevantRelations);
	}
	
	/**
	 * If we have both an inheritance and a composition between two classes, only return the inheritance.
	 * @param relations
	 * @return
	 */
	private List<JavaRelation> favourInheritanceOverCopmosition(List<JavaRelation> relations) {
		List<JavaRelation> filteredRelations = new ArrayList<>();
		filteredRelations.addAll(relations);
		for(JavaRelation relation: relations) {
			if(relation instanceof JavaInheritance) {
				for(JavaRelation filterOutRelation: relations) {
					if(filterOutRelation instanceof JavaComposition 
							&& filterOutRelation.getSourceElement().equals(relation.getSourceElement())
							&& filterOutRelation.getDestinationElement().equals(relation.getDestinationElement())) {
						filteredRelations.remove(filterOutRelation);
					}
				}
			}
		}
		return filteredRelations;
	}
	
	/**
	 * Add a class to the model, adds structural dependencies and notify all listeners.
	 * @param clazz
	 */
	public void addJavaClass(final JavaClass clazz) {
		mergeJavaClass(clazz);
	}
	
	/**
	 * Add a JavaClass to the model if it is not already in the model.
	 * 
	 * If there is an equal class already in the model return that class otherwise return 
	 * the added class. 
	 * 
	 * @param element
	 * @return
	 */
	/*default*/ JavaClass mergeJavaClass(JavaClass element) {
		JavaClass clazz = getJavaClass(element);
		if(clazz == null) {
			classes.add(element);
			notifyListeners(this);
			EventBus.get().fireEvent(new JavaClassAddedToModelEvent(element));
			return element;
		} else {
			clazz.synchronizeWithWorkspace();
		}
		return clazz;
	}
	
	/**
	 * Remove a class from the model and notify all listeners.
	 * @param existingClass
	 */
	/*default*/ void removeJavaClass(final JavaClass clazz) {
		JavaClass existingClass = getJavaClassByFullyQualifiedName(clazz.getFullyQualifiedName());
		classes.remove(existingClass);
		notifyListeners(this);
	}
	
	/**
	 * Changes the degree of interest of a class.
	 * 
	 * If class is not present in the ContextModel the class is added to the model.
	 * 
	 * @param element the {@link JavaClass} to change
	 * @param delta the change to the degreeOfInterest of element
	 */
	public void changeRelevance(JavaElement element, double delta) {
		checkNotNull(element);
		
		element.changeRelevance(delta);
		notifyListeners(this);
	}
	
	/**
	 * Reloads all existing classes in the model from the Eclipse Workspace.
	 * @throws JavaModelException 
	 */
	public void synchronizeWithWorkspace(){
		for(JavaClass clazz: classes) {
			clazz.synchronizeWithWorkspace();
		}
	}
	
	/**
	 * Finds a JavaClass by its fully qualified name.
	 * 
	 * @param fullyQualifiedName
	 * @return
	 */
	public JavaClass getJavaClassByFullyQualifiedName(String fullyQualifiedName) {
		for(JavaClass clazz: classes) {
			if(clazz.getFullyQualifiedName().equals(fullyQualifiedName)) {
				return clazz;
			}
		}
		return null;
	}
	
	/**
	 * Returns a JavaClass from the model which has the same fully qualified name as element.
	 * 
	 * @param element
	 * @return
	 */
	private JavaClass getJavaClass(JavaClass element) {
		return getJavaClassByFullyQualifiedName((element).getFullyQualifiedName());
	}

	/**
	 * 
	 * @return a list of all relations in the model
	 */
	public List<JavaRelation> getRelations() {
		return relations;
	}
	
	/**
	 * Add a JavaRelation to the model and update the references (source and destination 
	 * element of the relation) to JavaElements in the model.
	 * 
	 * @param relation to be added to the model
	 */
	/*default*/ JavaRelation mergeRelation(JavaRelation relation) {
		if(relation.getSourceElement() == null || relation.getDestinationElement() == null) {
			return null;
		}
		
		for(JavaRelation r: relations) {
			if(r.equals(relation)) {
				return r;
			}
		}
		relations.add(relation);
		if(relation instanceof JavaCallRelation) {
			EventBus.get().fireEvent(new JavaCallRelationFoundEvent((JavaCallRelation)relation));
		}
		return relation;
	}
	
	/**
	 * The active element will be highlighted in the diagram.
	 * 
	 * @return the element that was set as active element by the rule engine.
	 */
	public JavaElement getActiveElement() {
		return activeElement;
	}
	
	
	/**
	 * Returns the class that contains the active element. 
	 * If no class is found it will return null.
	 * 
	 * @return
	 */
	public JavaClass getActiveClass() {
		if(activeElement instanceof JavaClass) {
			return (JavaClass)activeElement;
		} else if(activeElement instanceof JavaMethod) {
			return ((JavaMethod)activeElement).getJavaClass();
		} else if(activeElement instanceof JavaField) {
			return ((JavaField)activeElement).getJavaClass();
		} else {
			return null;
		}
	}
	
	/**
	 * The active element will be highlighted in the diagram.
	 * 
	 * When a new element is set active, all listeners will be notified.
	 * 
	 * @param element
	 */
	public void setActiveElement(JavaElement element) {
		if(activeElement != null) {
			activeElement.setActive(false);
		}
		element.setActive(true);
		if(element instanceof JavaMethod) {
			MethodAnalyzer analyzer = new MethodAnalyzer((JavaMethod)element);
			analyzer.getCallers();
			analyzer.getCallees();
		}
		
		this.activeElement = element;
		notifyListeners(this);
	}
	
	/**
	 * @param method
	 * @return all source elements of JavaCallRelations with destination method.
	 */
	public List<JavaMethod> getCallers(JavaMethod method) {
		List<JavaMethod> callers = new ArrayList<>();
		if(activeElement instanceof JavaMethod) {
			for(JavaRelation relation: getRelations()) {
				if(relation instanceof JavaCallRelation) {
					if(relation.getDestinationElement().equals(method)) {
						callers.add((JavaMethod)relation.getSourceElement());
					}
				}
			}
		}
		return callers;
	}
	
	/**
	 * @param method
	 * @return all source elements of JavaCallRelations with source method.
	 */
	public List<JavaMethod> getCallees(JavaMethod method) {
		List<JavaMethod> callees = new ArrayList<>();
		if(activeElement instanceof JavaMethod) {
			for(JavaRelation relation: getRelations()) {
				if(relation instanceof JavaCallRelation) {
					if(relation.getSourceElement().equals(method)) {
						callees.add((JavaMethod)relation.getDestinationElement());
					}
				}
			}
		}
		return callees;
	}

}
