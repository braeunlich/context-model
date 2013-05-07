package ch.uzh.ifi.seal.contextmodels.trackers;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaFieldSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

@SuppressWarnings("restriction")
public class SelectionTracker extends Tracker implements ISelectionListener {

	@Override
	public void registerTracker(IWorkbenchWindow window) {
		window.getSelectionService().addPostSelectionListener(this);
	}

	@Override
	public void unregisterTracker(IWorkbenchWindow window) {
		window.getSelectionService().removePostSelectionListener(this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof TreeSelection) {
			handleTreeSelection((TreeSelection) selection);
		} else if (selection instanceof TextSelection) {
			if (part instanceof CompilationUnitEditor) {
				handleTextSelection((TextSelection) selection,
						(CompilationUnitEditor) part);
			}
		}
	}

	private void handleTextSelection(TextSelection selection,
			CompilationUnitEditor editor) {
		ICompilationUnit root = (ICompilationUnit) EditorUtility
				.getEditorInputJavaElement((IEditorPart) editor, false);
		try {
			ITextSelection sel = (ITextSelection) ((JavaEditor) editor)
					.getSelectionProvider().getSelection();

			IJavaElement element = root.getElementAt(sel.getOffset());

			if (element == null) {
				return;
			}

			if (element.getElementType() == IJavaElement.METHOD) {
				sourceMethodSelected((IMethod) element);
			} else if (element.getElementType() == IJavaElement.FIELD) {
				sourceFieldSelected((IField) element);
			} 
			
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

	}

	private void handleTreeSelection(TreeSelection selection) {
		if (!selection.isEmpty()) {
			if (selection.getFirstElement() instanceof CompilationUnit) {
				compilationUnitSelected((CompilationUnit) selection
						.getFirstElement());
			} else if (selection.getFirstElement() instanceof SourceField) {
				sourceFieldSelected((SourceField) selection.getFirstElement());
			} else if (selection.getFirstElement() instanceof SourceMethod) {
				sourceMethodSelected((SourceMethod) selection.getFirstElement());
			}
		}
	}

	private void sourceMethodSelected(IMethod jdtMethod) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaMethod method = model.getMethodInModel(jdtMethod);
		EventBus.get().fireEvent(new JavaMethodSelectedEvent(method));
	}

	private void sourceFieldSelected(IField jdtField) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaField field = model.getFieldInModel(jdtField);
		EventBus.get().fireEvent(new JavaFieldSelectedEvent(field));
	}

	private void compilationUnitSelected(CompilationUnit compilationUnit) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaClass clazz = model
				.getJavaClassFromCompilationUnit(compilationUnit);
		EventBus.get().fireEvent(new JavaClassSelectedEvent(clazz));
	}

}
