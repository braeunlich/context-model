package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class Transcript11 extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("org.cesilko.rachota.gui.HistoryView", "org.cesilko.rachota.gui.MainWindow");
	}
	
	@Override
	protected String getProjectName() {
		return "Rachota";
	}
	
	@Override
	protected void runTranscript() throws InterruptedException {
		// Transcript 11
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.TaskDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.TaskDialog", "btOKActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "filterTasks")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btBackwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "cmbPeriodItemStateChanged")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		
	}

	

}
