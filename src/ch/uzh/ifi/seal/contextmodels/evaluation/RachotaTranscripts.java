package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class RachotaTranscripts extends AbstractTranscriptRunner {

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
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "PropertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btForwardActionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "filterTasks")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "btBackwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "cmbPeriodItemStateChanged")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "ptForwardActionPerformed")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		
		// Transcript 20
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryChart")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("HistoryView.MouseActionAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("HistoryView.MouseActionAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("HistoryView.MouseActionAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("HistoryView.MouseActionAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("HistoryView.MouseActionAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("FilteredTasksTableModel")));
		fire(new JavaClassSelectedEvent(clazz("FilteredTasksTableModel")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		
		// transcript 26
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChnage")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "addPropertyChangeListener")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChnage")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "DayView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "getDays")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "setDay")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChnage")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "updateInformation")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChnage")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "setDay")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "setDay")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "saveSetup")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "addTask")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "getDays")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "getDay")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "getDay")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
	}

	

}
