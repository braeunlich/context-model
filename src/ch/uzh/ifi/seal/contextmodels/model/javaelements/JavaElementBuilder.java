package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import org.eclipse.jdt.core.IType;

import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;

/**
 * This class helps to restrict JavaElement Creation.
 * 
 * @author chb
 *
 */
public class JavaElementBuilder {

	private JavaElementBuilder() {}
	
	/**
	 * This class should only be loaded by JdtContextModelAdapter (which makes sure that the elements are part of the model). 
	 * If you want to get a JavaElement, use JdtContextModelAdapter or ContextModel to get it.
	 * 
	 * The argument JdtContextModelAdapter should encourage developers to look into this class.
	 * 
	 * 
	 * @param model
	 * @return
	 */
	public static JavaElementBuilder get(JdtContextModelAdapter model) {
		if(model == null) {
			return null;
		}
		
		return new JavaElementBuilder();
	}
	
	public JavaClass createJavaClass(IType jdtType) {
		return new JavaClass(jdtType);
	}
	
	public JavaInheritance createJavaInheritance(JavaElement parentElement,
			JavaElement childElement) {
		return new JavaInheritance(parentElement, childElement);
	}
	
	public JavaComposition createComposition(JavaElement source, JavaElement target, JavaField field) {
		return new JavaComposition(source, target, field);
	}
	
	public JavaCallRelation createCallRelation(JavaMethod source, JavaMethod destination) {
		return new JavaCallRelation(source, destination);
	}
	
}
