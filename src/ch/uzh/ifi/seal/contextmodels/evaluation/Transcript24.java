package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;
/**
 * Transcript #24 ( FreeMind )
 * 
 * 
 * @author chb
 *
 */
public class Transcript24 extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("freemind.modes.mindmapmode.MindMapMapModel", "freemind.modes.ControllerAdapter");
	}
	
	@Override
	protected String getProjectName() {
		return "FreeMind_integration";
	}
	
	@Override
	public void runTranscript() throws InterruptedException {
		
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.EncryptedMindMapNode", "save")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.EncryptedMindMapNode")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.NodeAdapter", "saveChildren")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.NodeAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "getXml")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "getXml")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "getXml")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "saveInternal")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaClassSelectedEvent(clazz("freemind.main.Resources")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.main.Resources")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.main.Resources")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel.DoAutomaticSave")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel.DoAutomaticSave", "run")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.MapAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.actions.ExportBranchAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapMapModel")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ModeController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ModeController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.actions.ExportBranchAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.actions.ExportBranchAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassKeyPressEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "save")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter", "saveAs")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.actions.ExportBranchAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassKeyPressEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.ExportWithXSLT")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.MindMapController")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.mindmapmode.MindMapController")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.SaveAll")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaClassSelectedEvent(clazz("accessories.plugins.SaveAll")));
		fire(new JavaClassKeyPressEvent(clazz("accessories.plugins.SaveAll")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.schememode.SchemeController")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.schememode.SchemeController")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.mindmapmode.MindMapMapModel", "save")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.mindmapmode.EncryptedMindMapNode")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAsAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAsAction")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaClassSelectedEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaMethodSelectedEvent(method("freemind.modes.ControllerAdapter.SaveAction", "actionPerformed")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));
		fire(new JavaClassKeyPressEvent(clazz("freemind.modes.ControllerAdapter.SaveAction")));

	}

	

	

}
