package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class JpassTranscripts extends AbstractTranscriptRunner {

	@Override
	protected DeveloperModel buildDeveloperModel() {
		return DeveloperModel.build().classNames("org.pwsafe.passwordsafeswt.action.LockDbAction", "org.pwsafe.passwordsafeswt.action.UnlockDbAction", "org.pwsafe.passwordsafeswt.PasswordSafeJFace", "org.pwsafe.passwordsafeswt.dialog.PasswordDialog");
	}
	
	@Override
	protected String getProjectName() {
		return "PasswordSafeSWT";
	}
	
	@Override
	protected void runTranscript() throws InterruptedException {
		// transcript 10
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.S3CredentialsDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.S3InformationComposite")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.UnlockDbAction", "performUnlock")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "showListView")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "addTableView")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.LockDbAction", "performLock")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		
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
		
		//transcript 22
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "openFile")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "openFile")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "openFile")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.action.UnlockDbAction", "")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.dialog.PasswordDialog")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaMethodSelectedEvent(method("org.pwsafe.passwordsafeswt.PasswordSafeJFace", "createActions")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.LockDbAction")));
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
		fire(new JavaClassKeyPressEvent(clazz("org.pwsafe.passwordsafeswt.PasswordSafeJFace")));
	}

	

}
