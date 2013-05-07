package ch.uzh.ifi.seal.contextmodels.model.javaelements;

public class JavaInheritance extends JavaRelation {

	protected JavaInheritance(JavaElement parentElement,
			JavaElement childElement) {
		
		super(parentElement, childElement);
	}

	public JavaElement getParentElement() {
		return super.getSourceElement();
	}
	
	public JavaElement getChildElement() {
		return super.getDestinationElement();
	}
	
	@Override
	public String toString() {
		return getChildElement()  + " is subtype of " + getParentElement();
	}
}
