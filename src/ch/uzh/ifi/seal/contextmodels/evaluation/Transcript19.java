package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class Transcript19 extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("org.pwsafe.passwordsafeswt.action.LockDbAction", "org.pwsafe.passwordsafeswt.action.UnlockDbAction", "org.pwsafe.passwordsafeswt.PasswordSafeJFace");
	}
	
	@Override
	protected String getProjectName() {
		return "PasswordSafeSWT";
	}
	
	@Override
	protected void runTranscript() throws InterruptedException {
		
		// transcript 19
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.model.AbstractTableLabelProvider")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.model.PasswordTableContentProvider")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.state.LockState")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.dialog.EditDialog", "update")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.dialog.EditDialog", "update")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.dialog.EditDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.EditDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.model.PasswordTableContentProvider")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.EditDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.model.PasswordTableContentProvider")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "addTableView")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "addTableView")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.listener.TableColumnSelectionAdaptor")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "addTableView")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.listener.TableColumnSelectionAdaptor")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.model.PasswordTableSorter")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "addTableView")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "setLocked")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "setSelectedRecord")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "setLocked")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.LockDbAction", "performLock")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.LockDbAction", "run")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "updateViewers")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.UnlockDbAction", "performUnlock")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "setLocked")));
		
	}

	

}
