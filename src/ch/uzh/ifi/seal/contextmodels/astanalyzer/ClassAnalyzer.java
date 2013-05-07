package ch.uzh.ifi.seal.contextmodels.astanalyzer;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaCompositionFoundEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaInheritanceFoundEvent;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaComposition;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public class ClassAnalyzer {

	private final JavaClass clazz;

	private ITypeHierarchy typeHierarchy;

	private JdtContextModelAdapter model;

	public ClassAnalyzer(JavaClass clazz) {
		this.clazz = clazz;
	}

	public void findRelatedElements() {
		Logger.info("AST Analyzer: Looking for structural dependencies (class: "
				+ clazz + ")");
		model = JdtContextModelAdapter.get();
		findRelevanHierarchy();
		try {
			findRelevantComposistion();
		} catch (JavaModelException e) {
			Logger.error("AST Analyzer: findRelatedElements: " + e.getMessage());
		}
	}

	private void findRelevanHierarchy() {
		try {
			typeHierarchy = clazz.getJdtType().newSupertypeHierarchy(null);
			findRelevantSuperType();
			findInterfaces();
		} catch (LinkageError | JavaModelException | NullPointerException e) {
			Logger.error("AST Analyzer: findRelevanHierarchy: "
					+ e.getMessage());
		}

	}

	private void findRelevantSuperType() throws JavaModelException {

		IType superclass = typeHierarchy.getSuperclass(clazz.getJdtType());

		if (!superclass.getFullyQualifiedName().equals("java.lang.Object")) {
			JavaClass parent = model.getJavaClass(superclass);
			JavaInheritance inheritance = model.getJavaInheritance(parent,
					clazz);

			EventBus.get()
					.fireEvent(new JavaInheritanceFoundEvent(inheritance));
		}

	}

	private void findInterfaces() throws JavaModelException {
		for (IType type : typeHierarchy.getSuperInterfaces(clazz.getJdtType())) {
			JavaClass parent = model.getJavaClass(type);
			JavaInheritance inheritance = model.getJavaInheritance(parent,
					clazz);

			EventBus.get()
					.fireEvent(new JavaInheritanceFoundEvent(inheritance));
		}
	}

	private void findRelevantComposistion() throws JavaModelException {
		for (JavaField field : clazz.getFields()) {

			IField jdtField = field.getJdtField();

			String className = JdtUtil.resolveTypeOfField(jdtField,
					clazz.getJdtType());

			if (className == null) {
				continue;
			}

			JdtContextModelAdapter model = JdtContextModelAdapter.get();
			ICompilationUnit cu = JdtUtil.lookUpCompilationUnit(className);

			if (cu == null) {
				continue;
			}

			JavaClass fieldType = model.getJavaClassFromCompilationUnit(cu);

			if (fieldType == null || fieldType.equals(clazz)) {
				continue;
			}

			JavaComposition composition = model.getJavaComposition(clazz,
					fieldType, field);

			EventBus.get()
					.fireEvent(new JavaCompositionFoundEvent(composition));
		}
	}

}
