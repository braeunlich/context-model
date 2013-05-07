package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class Transcript26 extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("org.cesilko.rachota.gui.HistoryChart", "org.cesilko.rachota.core.Plan", "org.cesilko.rachota.core.Day", "org.cesilko.rachota.gui.DayView", "org.cesilko.rachota.gui.HistoryView", "org.cesilko.rachota.gui.MainWindow");
	}
	
	@Override
	protected String getProjectName() {
		return "Rachota";
	}
	
	@Override
	protected void runTranscript() throws InterruptedException {
		
		// transcript 26
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "addPropertyChangeListener")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChange")));
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
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChange")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "updateInformation")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.MainWindow", "MainWindow")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.DayView")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "propertyChange")));
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
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "addTask")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "getDays")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.core.Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "getDay")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.core.Day", "Day")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.DayView", "getDay")));
		fire(new JavaMethodSelectedEvent(method("org.cesilko.rachota.gui.HistoryView", "propertyChange")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassSelectedEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
		fire(new JavaClassKeyPressEvent(clazz("org.cesilko.rachota.gui.HistoryView")));
	}

	

}
