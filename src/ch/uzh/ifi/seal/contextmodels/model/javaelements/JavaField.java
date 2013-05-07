package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

public class JavaField extends AbstractJavaElement {
	
	private String name;
	private String type;
	private JavaFieldAccessModifier modifier;
	private final JavaClass clazz;
	private final IField jdtField;

	/*default*/ JavaField(String name, String type, JavaFieldAccessModifier modifier) {
		this.name = name;
		this.type = type;
		this.modifier = modifier;
		this.clazz = null;
		this.jdtField = null;
	}

	protected JavaField(IField jdtField, JavaClass clazz) throws JavaModelException {
		this.name = jdtField.getElementName();
		this.type = jdtField.getTypeSignature();
		this.modifier = JavaFieldAccessModifier.parseJDTFlags(jdtField.getFlags());
		this.clazz = clazz;
		this.jdtField = jdtField;
	}
	
	public IField getJdtField() {
		return jdtField;
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
	
	public JavaFieldAccessModifier getModifier() {
		return modifier;
	}
	
	public void setModifier(JavaFieldAccessModifier modifier) {
		this.modifier = modifier;
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
		JavaField other = (JavaField) obj;
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
