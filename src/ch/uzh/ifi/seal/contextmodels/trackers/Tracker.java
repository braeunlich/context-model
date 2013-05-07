package ch.uzh.ifi.seal.contextmodels.trackers;

import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchWindow;

public abstract class Tracker implements IWindowListener {
	
	@Override
	public void windowActivated(IWorkbenchWindow window) {
	}
	
	@Override
	public void windowDeactivated(IWorkbenchWindow window) {
	}
	
	@Override
	public void windowOpened(IWorkbenchWindow window) {
		registerTracker(window);
	}
	
	@Override
	public void windowClosed(IWorkbenchWindow window) {
		unregisterTracker(window);
	}
	
	public abstract void registerTracker(IWorkbenchWindow window);
	public abstract void unregisterTracker(IWorkbenchWindow window);
	
}
