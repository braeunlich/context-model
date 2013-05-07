package ch.uzh.ifi.seal.contextmodels.trackers;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.ui.IEditorPart;

import ch.uzh.ifi.seal.contextmodels.actions.EditorActions;

/**
 * Tracks opening and closing of ICompilationUnits in editors.
 * This Tracker can be added to a Workspace as a WindowListener. 
 * 
 * @author Christoph Braeunlich
 *
 */
@SuppressWarnings("restriction")
public abstract class CompilationUnitTracker extends EditorTracker {

	
	@Override
	public void editorOpened(IEditorPart part) {
		if(part instanceof CompilationUnitEditor) {
			Object viewPartInput = ((CompilationUnitEditor)part).getViewPartInput();
			if(viewPartInput instanceof ICompilationUnit) {
				registerEditorActions((CompilationUnitEditor) part, (ICompilationUnit)viewPartInput);
				compilationUnitOpened((ICompilationUnit)viewPartInput);
			}
		}
	}

	@Override
	public void editorClosed(IEditorPart part) {
		if(part instanceof CompilationUnitEditor) {
			Object viewPartInput = ((CompilationUnitEditor)part).getViewPartInput();
			if(viewPartInput instanceof ICompilationUnit) {
				compilationUnitClosed((ICompilationUnit)viewPartInput);
			}
		}
	}
	
	@Override
	public void editorBroughtToTop(IEditorPart part) {
		if(part instanceof CompilationUnitEditor) {
			Object viewPartInput = ((CompilationUnitEditor)part).getViewPartInput();
			if(viewPartInput instanceof ICompilationUnit) {
				compilationUnitBroughtToTop((ICompilationUnit)viewPartInput);
			}
		}
	}
	
	private void registerEditorActions(CompilationUnitEditor editor,
			ICompilationUnit compilationUnit) {
		
		EditorActions actions = new EditorActions(compilationUnit);
		
		editor.getViewer().getTextWidget().addKeyListener(actions);
		editor.getViewer().getTextWidget().addMouseWheelListener(actions);
		
	}
	
	/**
	 * Called when a ICompilationUnit is opened in an Editor.
	 * 
	 * @param viewPartInput the opened ICompilationUnit
	 */
	public abstract void compilationUnitOpened(ICompilationUnit viewPartInput);
	
	/**
	 * Called when a ICompilationUnit is closed in an Editor.
	 * 
	 * @param viewPartInput the closed ICompilationUnit
	 */
	public abstract void compilationUnitClosed(ICompilationUnit viewPartInput);
	
	/**
	 * Called when a ICompilationUnit is brought to top in an Editor.
	 * 
	 * @param viewPartInput the ICompilationUnit
	 */
	public abstract void compilationUnitBroughtToTop(ICompilationUnit viewPartInput);
}