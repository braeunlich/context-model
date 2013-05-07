package ch.uzh.ifi.seal.contextmodels.model;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaCallRelation;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaComposition;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElementBuilder;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

/**
 * Interface between ContextModel and JDT.
 * 
 * @author chb
 * 
 */
public class JdtContextModelAdapter {

	private final ContextModel model;
	private static JdtContextModelAdapter instance;
	private final JavaElementBuilder builder;

	private JdtContextModelAdapter(final ContextModel model) {
		this.model = model;
		builder = JavaElementBuilder.get(this);
	}

	public static JdtContextModelAdapter get() {
		if (instance == null) {
			instance = new JdtContextModelAdapter(ContextModel.get());
		}
		return instance;
	}

	/**
	 * Finds a JavaMethod in the ContextModel which resembles the JDTMethod (
	 * {@link IMethod}).
	 * 
	 * If the method is not in the model, the method and the declaring type will
	 * be added.
	 * 
	 * @param jdtMethod
	 * @return a JavaMethod in the ContextModel
	 */
	public JavaMethod getMethodInModel(IMethod jdtMethod) {
		IType type = findDeclaringJdtType(jdtMethod);
		JavaClass clazz = getJavaClass(type);
		return clazz.getMethodByJdtMethod(jdtMethod);
	}

	private IType findDeclaringJdtType(IMethod jdtMethod) {
		IJavaElement parent = jdtMethod.getParent();

		while (!(parent instanceof IType) && (parent != null)) {
			parent = parent.getParent();
		}

		return (IType) parent;
	}

	/**
	 * Finds a JavaField in the ContextModel which resembles the JDTField (
	 * {@link IField}.
	 * 
	 * If the field is not in the model, the field and the declaring type will
	 * be added.
	 * 
	 * @param jdtField
	 * @return a JavaField in the ContextModel
	 */
	public JavaField getFieldInModel(IField jdtField) {
		IType type = findDeclaringJdtType(jdtField);
		JavaClass clazz = getJavaClass(type);
		return clazz.getFieldByJdtField(jdtField);
	}

	private IType findDeclaringJdtType(IField jdtField) {
		IJavaElement parent = jdtField.getParent();

		while (!(parent instanceof IType) && (parent != null)) {
			parent = parent.getParent();
		}

		return (IType) parent;
	}

	/**
	 * Finds a JavaClass in the ContextModel. If there is no associated class a
	 * new JavaClass will be generated and added to the model.
	 * 
	 * @param type
	 *            JDTType ({@link IType})
	 * @return a JavaClass in the ContextModel.
	 */
	public JavaClass getJavaClass(IType type) {
		return model.mergeJavaClass(builder.createJavaClass(type));
	}

	/**
	 * Tries to find a primary class in a compilation unit and returns a
	 * JavaClass of the ContextModel.
	 * 
	 * If the class is not part of the ContextModel it will be added.
	 * 
	 * 
	 * @param compilationUnit
	 * @return JavaClass which resembles a Primary Class of a CompilationUnit.
	 */
	public JavaClass getJavaClassFromCompilationUnit(ICompilationUnit unit) {
		IType type = unit.findPrimaryType();
		if (type != null) {
			return getJavaClass(type);
		}

		return null;
	}

	/**
	 * Finds a JavaInheritance in the ContextModel. If no inheritance between
	 * the parent and child exists in the model a new one is created and added
	 * to the model.
	 * 
	 * @param parent
	 * @param child
	 * @return the JavaInheritance between parent and child in the model.
	 */
	public JavaInheritance getJavaInheritance(JavaClass parent, JavaClass child) {
		return (JavaInheritance) model.mergeRelation(builder
				.createJavaInheritance(parent, child));
	}

	public JavaComposition getJavaComposition(JavaClass source,
			JavaClass target, JavaField field) {
		return (JavaComposition) model.mergeRelation(builder.createComposition(
				source, target, field));
	}

	public JavaCallRelation getJavaCallRealtion(JavaMethod source,
			JavaMethod destination) {
		return (JavaCallRelation) model.mergeRelation(builder
				.createCallRelation(source, destination));
	}

}
