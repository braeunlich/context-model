package ch.uzh.ifi.seal.contextmodels.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeDeclarationMatch;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ch.uzh.ifi.seal.contextmodels.view.DiagramView;

/**
 * Utility class for common tasks related to Eclipse Java Development Tools.
 */
public class JdtUtil {

	/**
	 * Get the active Context Model Diagram View.
	 * 
	 * @return DiagramView
	 */
	public static DiagramView getContextModelDiagramView() {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getWorkbenchWindows()[0];
		IViewPart view = window.getActivePage().findView(
				"ch.uzh.ifi.seal.contextmodels.view.DiagramView");
		return (DiagramView) view;
	}

	/**
	 * Uses a fully qualified class name to open the class in the Java Editor.
	 */
	public static void openClassInJavaEditor(String className) {
		ICompilationUnit unit = JdtUtil.lookUpCompilationUnit(className);
		openJavaElementInJavaEditor(unit);
	}

	/**
	 * Open A JavaElement in the JavaEditor.
	 * 
	 * @param element
	 */
	public static void openJavaElementInJavaEditor(IJavaElement element) {
		try {
			JavaUI.openInEditor(element);
		} catch (PartInitException | JavaModelException e) {
			Logger.warning(e.getMessage());
		}
	}

	/**
	 * Searches the Eclipse Workspace for a CompilationUnit for a given fully
	 * qualified class name.
	 * 
	 * @param className
	 * @return
	 */
	public static ICompilationUnit lookUpCompilationUnit(String className) {
		SearchPattern sp = SearchPattern.createPattern(className,
				IJavaSearchConstants.TYPE, IJavaSearchConstants.DECLARATIONS,
				SearchPattern.R_FULL_MATCH);

		SearchEngine se = new SearchEngine();
		UnitRequestor ur = new UnitRequestor();
		SearchParticipant[] part = { SearchEngine.getDefaultSearchParticipant() };

		try {
			se.search(sp, part, SearchEngine.createWorkspaceScope(), ur,
					new NullProgressMonitor());
		} catch (CoreException e) {
			Logger.warning(e.getMessage());
		}

		if (ur.getIJavaElement() != null)
			return (ICompilationUnit) ur.getIJavaElement().getAncestor(
					IJavaElement.COMPILATION_UNIT);
		else
			return null;

	}

	private static class UnitRequestor extends SearchRequestor {
		IJavaElement ije = null;

		public void acceptSearchMatch(SearchMatch match) throws CoreException {
			if (match instanceof TypeDeclarationMatch) {
				if (match.getElement() instanceof IJavaElement)
					ije = (IJavaElement) ((TypeDeclarationMatch) match)
							.getElement();
			}
		}

		public IJavaElement getIJavaElement() {
			return ije;
		}
	}

	/**
	 * Tries to find the type of an IField in the scope of an IType. If multiple
	 * possibilities were fond, the first one will be returned.
	 * 
	 * 
	 * @param field
	 * @param clazz
	 *            the parent class of the field
	 * @return the fully qualified name of the type of the field or null if no
	 *         type was found.
	 * @throws JavaModelException
	 */
	public static String resolveTypeOfField(IField field, IType clazz)
			throws JavaModelException {

		String typeString = null;

		try {
			String typeName = Signature.getSignatureSimpleName(field
					.getTypeSignature());
			String[][] type = clazz.resolveType(typeName);
			if (type != null && type.length > 0) {
				typeString = type[0][0] + "." + type[0][1];
			}
		} catch (JavaModelException e) {
			return null;
		}

		return typeString;
	}

}
