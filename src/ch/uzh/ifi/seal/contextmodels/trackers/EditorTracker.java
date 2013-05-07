package ch.uzh.ifi.seal.contextmodels.trackers;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

public abstract class EditorTracker extends Tracker implements IPageListener,
		IPartListener {

	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorBroughtToTop((IEditorPart) part);
		}
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorClosed((IEditorPart) part);
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			editorOpened((IEditorPart) part);
		}
	}

	@Override
	public void pageActivated(IWorkbenchPage page) {
	}

	@Override
	public void pageClosed(IWorkbenchPage page) {
		page.removePartListener(this);
	}

	@Override
	public void pageOpened(IWorkbenchPage page) {
		page.addPartListener(this);
	}

	@Override
	public void registerTracker(IWorkbenchWindow window) {
		window.addPageListener(this);
		// Need to add listener to each page because pages are opened before
		// the windowOpened is called (workbench.fireOpenWindow() ).
		for (IWorkbenchPage page : window.getPages()) {
			page.addPartListener(this);
		}
	}
	
	@Override
	public void unregisterTracker(IWorkbenchWindow window) {
		window.removePageListener(this);
		for (IWorkbenchPage page : window.getPages()) {
			page.removePartListener(this);
		}
	}

	public abstract void editorOpened(IEditorPart part);

	public abstract void editorClosed(IEditorPart part);
	
	public abstract void editorBroughtToTop(IEditorPart part);

}
