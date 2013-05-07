package ch.uzh.ifi.seal.contextmodels.model.javaelements;

public class JavaComposition extends JavaRelation {

	private final JavaField field;
	
	/* default */ JavaComposition(JavaElement sourceElement,
			JavaElement destinationElement, JavaField field) {
		super(sourceElement, destinationElement);
		this.field = field;
	}
	
	@Override
	public String toString() {
		return getSourceElement() + " contains " + getDestinationElement();
	}
	
	public JavaField getField() {
		return field;
	}

}
