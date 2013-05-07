package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import java.util.List;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public interface ExecutionContext {

	void execute(Task task);
	
	void overwriteAffectedElements(List<? extends JavaElement> affectedElements);
	
	void setAffectsAllElements();
	
}
