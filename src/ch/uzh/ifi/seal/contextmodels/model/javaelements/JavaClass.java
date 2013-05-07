package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassBecomesRelevantEvent;
import ch.uzh.ifi.seal.contextmodels.model.Relevance;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public class JavaClass extends AbstractJavaElement {

	private String name;
	private String fullyQualifiedName;
	private List<JavaField> fields = new ArrayList<>();
	private List<JavaMethod> methods = new ArrayList<>();
	private IType jdtType;
	
	private boolean isRelevant = false;

	/* default */JavaClass(String name) {
		this.name = name;
		this.fullyQualifiedName = "?." + name;
	}

	protected JavaClass(IType jdtType) {
		this.jdtType = jdtType;
		synchronizeWithWorkspace();
	}

	public void synchronizeWithWorkspace() {
		if (jdtType == null) {
			return;
		}

		try {
			this.name = jdtType.getElementName();
			this.fullyQualifiedName = jdtType.getFullyQualifiedName();
			synchronizeMethods();
			synchronizeFields();

		} catch (JavaModelException e) {
			Logger.error(e.getMessage());
		}
	}

	private void synchronizeMethods() throws JavaModelException {
		List<JavaMethod> newMethods = new ArrayList<>();

		for (IMethod jdtMethod : jdtType.getMethods()) {
			newMethods.add(findMethod(new JavaMethod(jdtMethod, this)));
		}

		methods = newMethods;
	}

	private JavaMethod findMethod(JavaMethod method) {
		for (JavaMethod m : methods) {
			if (m.equals(method)) {
				return m;
			}
		}
		return method;
	}

	private void synchronizeFields() throws JavaModelException {
		List<JavaField> newFields = new ArrayList<>();

		for (IField jdtField : jdtType.getFields()) {
			newFields.add(findField(new JavaField(jdtField, this)));
		}

		fields = newFields;
	}

	private JavaField findField(JavaField field) {
		for (JavaField f : fields) {
			if (f.equals(field)) {
				return f;
			}
		}
		return field;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JavaField> getFields() {
		return fields;
	}

	public void addField(JavaField field) {
		fields.add(field);
	}
	
	public JavaField getFieldByJdtField(IField jdtField) {
		for(JavaField field: fields) {
			if(field.getJdtField().equals(jdtField)) {
				return field;
			}
		}
		return null;
	}

	public void removeField(JavaField field) {
		fields.remove(field);
	}

	public List<JavaMethod> getMethods() {
		return methods;
	}

	public JavaMethod getMethodByJdtMethod(IMethod jdtMethod) {
		for (JavaMethod method : methods) {
			if (method.getJdtMethod().equals(jdtMethod)) {
				return method;
			}
		}
		return null;
	}

	public void addMethod(JavaMethod method) {
		methods.add(method);
	}

	public void removeMethod(JavaMethod method) {
		methods.remove(method);
	}

	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	public IType getJdtType() {
		return jdtType;
	}

	
	@Override
	protected void validateRelevance() {
		super.validateRelevance();
		
		if(! isRelevant && isRelevant()) {
			EventBus.get().fireEvent(new JavaClassBecomesRelevantEvent(this));
		}
		isRelevant = isRelevant();
	}
	
	/**
	 * Is is relevant if it contains a relevant mathod or field.
	 */
	@Override
	public boolean isRelevant() {
		double maxRelevance = relevance;
		for (JavaMethod method : methods) {
			if (method.getRelevance() > maxRelevance) {
				maxRelevance = method.getRelevance();
			}
		}

		for (JavaField field : fields) {
			if (field.getRelevance() > maxRelevance) {
				maxRelevance = field.getRelevance();
			}
		}

		return maxRelevance > Relevance.getRelevancyThreshold();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JavaClass))
			return false;

		return getFullyQualifiedName().equals(
				((JavaClass) obj).getFullyQualifiedName());
	}

	@Override
	public int hashCode() {
		return getFullyQualifiedName().hashCode();
	}

	@Override
	public String toString() {
		return fullyQualifiedName;
	}

}
