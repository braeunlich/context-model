package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;
/**
 * Transcript #9 ( FreeMind )
 * 
 * 
 * @author chb
 *
 */
public class Transcript09 extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("freemind.controller.Controller", "freemind.modes.ControllerAdapter");
	}
	
	@Override
	protected String getProjectName() {
		return "FreeMind_integration";
	}
	
	@Override
	public void runTranscript() throws InterruptedException {
		
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.MapAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.MapAdapter", "save")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.EditAttributesAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapController")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel.DoAutomaticSave", "run")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel.DoAutomaticSave", "run")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel.DoAutomaticSave", "run")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.MapAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.browsemode.BrowseMapModel", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.filemode.FileMapModel", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.MapAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.schememode.SchemeMapModel", "save")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ModeController", "save")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ModeController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ModeController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.MapAdapter", "getFrame")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaMethodSelectedEvent(method("freemind.main.FreeMindMain", "out")));
		fire(new JavaClassSelectedEvent(clazz("freemind.main.FreeMind")));
		fire(new JavaMethodSelectedEvent(method("freemind.main.FreeMindApplet", "out")));
		fire(new JavaMethodSelectedEvent(method("tests.freemind.FreeMindMainMock", "out")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAsAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ModeController", "save")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ModeController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "close")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.actions.ExportBranchAction", "actionPerformed")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAsAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.actions.ExportBranchAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaMethodSelectedEvent(method("accessories.plugins.ExportWithXSLT", "startupMapHook")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapController", "invokeHook")));
		fire(new JavaClassKeyPressEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapController", "loadURL")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapController")));
		fire(new JavaMethodSelectedEvent(method("freemind.main.Resources", "logException")));
		fire(new JavaMethodSelectedEvent(method("freemind.main.Resources", "logException")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapController", "loadURL")));
		fire(new JavaMethodSelectedEvent(method("accessories.plugins.SaveAll", "startupMapHook")));
		fire(new JavaClassKeyPressEvent(clazz("accessories.plugins.SaveAll")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.schememode.SchemeController", "saveAs")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.schememode.SchemeController")));
		
	}

	

	

}
