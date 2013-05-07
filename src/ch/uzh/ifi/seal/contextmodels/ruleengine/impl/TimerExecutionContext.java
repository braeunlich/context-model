package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.widgets.Display;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public class TimerExecutionContext extends JavaElementExecutionContext {

	private int timeInMiliseconds;
	
	public TimerExecutionContext(int timeInMiliseconds) {
		this.timeInMiliseconds = timeInMiliseconds;
	}
	
	@Override
	public void execute(final Task task) {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Display.getDefault().asyncExec(new Runnable() {
				    public void run() {
						for(JavaElement element: getAffectedJavaElements()) {
							task.run(element);
						}
				    }
				});
			}
		}, timeInMiliseconds, timeInMiliseconds);
	}


}
