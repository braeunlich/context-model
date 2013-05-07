package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;

public class JavaMethod extends AbstractJavaElement {

	private String name;
	private String type;
	private JavaMethodAccessModifier modifier;
	private List<String> argumentNames = new ArrayList<>();
	private final IMethod jdtMethod;
	private final JavaClass clazz;

	//
	// Constructors should only be accessible from within the package and
	// subclasses
	// to prevent generating JavaMethods not connected to the model.
	//
	// i.e.: constructors should only be used by the Type implementing the
	// method.
	//

	/**
	 * Convenience Constructor for testing.
	 * 
	 * @param name
	 * @param type
	 * @param modifier
	 * @param clazz
	 */
	/* default */JavaMethod(final String name, final String type,
			final JavaMethodAccessModifier modifier, final JavaClass clazz) {
		this.clazz = clazz;
		this.name = name;
		this.type = type;
		this.modifier = modifier;
		this.jdtMethod = null;
	}

	protected JavaMethod(final IMethod jdtMethod, final JavaClass clazz)
			throws JavaModelException {
		this.clazz = clazz;
		this.jdtMethod = jdtMethod;
		this.name = jdtMethod.getElementName();
		this.type = jdtMethod.getReturnType();
		this.modifier = JavaMethodAccessModifier.parseJDTFlags(jdtMethod
				.getFlags());

		for (String argument : jdtMethod.getParameterNames()) {
			argumentNames.add(argument);
		}
	}

	public JavaClass getJavaClass() {
		return clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModifier(JavaMethodAccessModifier modifier) {
		this.modifier = modifier;
	}

	public JavaMethodAccessModifier getModifier() {
		return modifier;
	}

	public List<String> getArgumentNames() {
		return argumentNames;
	}

	public void addArgumentName(String argumentName) {
		argumentNames.add(argumentName);
	}

	public void removeArgumentName(String argumentName) {
		argumentNames.remove(argumentName);
	}

	public IMethod getJdtMethod() {
		return jdtMethod;
	}

	@Override
	public String toString() {
		return modifier + " " + type + " " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((argumentNames == null) ? 0 : argumentNames.hashCode());
		result = prime * result
				+ ((modifier == null) ? 0 : modifier.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaMethod other = (JavaMethod) obj;
		if (argumentNames == null) {
			if (other.argumentNames != null)
				return false;
		} else if (!argumentNames.equals(other.argumentNames))
			return false;
		if (modifier != other.modifier)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
