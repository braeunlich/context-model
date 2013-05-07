package ch.uzh.ifi.seal.contextmodels.model.javaelements;

public class JavaCallRelation extends JavaRelation {

	/*default*/ JavaCallRelation(JavaMethod source, JavaMethod destination) {
		super(source, destination);
	}
	
	public JavaMethod getCaller() {
		return (JavaMethod)getSourceElement();
	}
	
	public JavaMethod getCallee() {
		return (JavaMethod)getDestinationElement();
	}

	@Override
	public String toString() {
		return "JavaCallRelation " + getCaller() + " -> " + getCallee(); 
	}
	
}
