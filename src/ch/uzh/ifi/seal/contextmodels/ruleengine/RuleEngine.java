package ch.uzh.ifi.seal.contextmodels.ruleengine;

import static ch.uzh.ifi.seal.contextmodels.model.Relevance.setImportanceThreashold;
import static ch.uzh.ifi.seal.contextmodels.model.Relevance.setMinimalRelevancy;
import static ch.uzh.ifi.seal.contextmodels.model.Relevance.setRelevancyThreshold;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.JavaElementSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaCallRelationFoundEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassBecomesRelevantEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaCompositionFoundEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaInheritanceFoundEvent;
import ch.uzh.ifi.seal.contextmodels.ruleengine.impl.RulesDslImpl;

public final class RuleEngine extends RulesDslImpl {
	
	private static RuleEngine instance;
	public static RuleEngine get() {
		if(instance == null) {
			instance = new RuleEngine();
		}
		return instance;
	}
	
	private RuleEngine() {}
	
	private static final double STEP = 0.05;
	
	public void init() {
		
		/* 
		 * Mik Kersten (2005): Mylar: a degree-of-interest model for IDEs: 
		 * 
		 * select JavaElement: +1 to JavaElement -0.1 to all
		 * keystroke: +0.1
		 * 
		 * display only elements with DoI over -10
		 */
		
		setRelevancyThreshold(0);
		setImportanceThreashold(2);
		setMinimalRelevancy(-0.9);
		
		onEvent(JavaElementSelectedEvent.class).increaseRelevancyBy(1. + STEP);
		onEvent(JavaElementSelectedEvent.class).forAllJavaElements().increaseRelevancyBy( -STEP);
		onEvent(JavaElementSelectedEvent.class).setActive();
		onEvent(JavaClassBecomesRelevantEvent.class).findStructuralDependencies();
		
		onEvent(JavaClassKeyPressEvent.class).increaseRelevancyBy(STEP);
		
		onEvent(JavaInheritanceFoundEvent.class).increaseRelevancyBy(100);
		
		onEvent(JavaCompositionFoundEvent.class).log("JavaComposition found!");
		onEvent(JavaCompositionFoundEvent.class).increaseRelevancyBy(100);
		
		onEvent(JavaCallRelationFoundEvent.class).log("JavaCallRelation found!");
		
//		onEvent(JavaClassOpenedEvent.class).increaseRelevancyBy(5);
//		onEvent(JavaClassClosedEvent.class).increaseRelevancyBy(-3);
//		
//		onEvent(DiagramClassClickEvent.class).increaseRelevancyBy(10);
//
//		onEvent(JavaClassSelectedEvent.class).log("javaClass selected");
//		
//		onEvent(DiagramClickEvent.class).log("Clicked on Diagram...");
//		
//		onEvent(DiagramClassClickEvent.class).log("Class clicked");
//		onEvent(DiagramFieldClickEvent.class).log("Field clicked");
//		onEvent(DiagramMethodClickEvent.class).log("Method clicked");
//		
//		onEvent(JavaClassScrollEvent.class).log("ClassScrollEvent");
//		onEvent(JavaClassKeyPressEvent.class).log("ClassKeyPressEvent");
//		
//		onEvent(JavaInheritanceFoundEvent.class).log("Java Inheritance found!!!");
//		
//		onEvent(JavaInheritanceFoundEvent.class).increaseRelevancyBy(100);
//		
//		every(5).seconds().forAllJavaElements().increaseRelevancyBy(-1);
		
	}
	
}
