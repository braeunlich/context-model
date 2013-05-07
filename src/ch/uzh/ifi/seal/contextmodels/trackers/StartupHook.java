package ch.uzh.ifi.seal.contextmodels.trackers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ch.uzh.ifi.seal.contextmodels.actions.CompilationUnitActions;
import ch.uzh.ifi.seal.contextmodels.ruleengine.RuleEngine;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public class StartupHook implements IStartup {

	private List<IWindowListener> actions = getActions();	
	private IWorkbench workbench = PlatformUI.getWorkbench();

	@Override
	public void earlyStartup() {
		
		Logger.setTesting();
		
		notifyHandlersForOpenWindows();
		registerActions();
		RuleEngine.get().init();
	}

	private List<IWindowListener> getActions() {
		List<IWindowListener> actions = new ArrayList<>();
		actions.add(new CompilationUnitActions());
		actions.add(new SelectionTracker());
		return actions;
	}

	/**
	 * Installs a handler which registers itself when a Window is opened.
	 */
	private void registerActions() {
		for(IWindowListener action: actions) {
			workbench.addWindowListener(action);
		}
	}

	/**
	 * Registers a handler to all open WorkspaceWindows.
	 */
	private void notifyHandlersForOpenWindows() {
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			for(IWindowListener action: actions) {
				action.windowOpened(window);
			}
		}
	}

}
