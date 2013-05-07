package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import java.util.ArrayList;
import java.util.List;

import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public abstract class  JavaElementExecutionContext implements ExecutionContext {

	private List<? extends JavaElement> affectedJavaElements = new ArrayList<>();
	private boolean affectsAllElements = false; 

	public <T extends JavaElement>  void addAffectedJavaElement(JavaElement affectedJavaElement) {
		List<JavaElement> tmp = new ArrayList<>();
		tmp.addAll(affectedJavaElements);
		tmp.add(affectedJavaElement);
		affectedJavaElements = tmp;
	}
	
	public void setAffectedJavaElements(List<? extends JavaElement> affectedElements)  {
		affectedJavaElements = affectedElements;
	}
	
	@Override
	public void overwriteAffectedElements(List<? extends JavaElement> affectedElements) {
		setAffectedJavaElements(affectedElements);
	}
	
	public List<? extends JavaElement> getAffectedJavaElements() {
		if(affectsAllElements) {
			return ContextModel.get().getAllJavaElements();
		}
		return affectedJavaElements;
	}
	
	@Override
	public void setAffectsAllElements() {
		affectsAllElements = true;
	}
}
