package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;

public class Transcript22 extends AbstractTranscriptRunner {

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
		fire(new JavaClassSelectedEvent(clazz("org.pwsafe.passwordsafeswt.action.UnlockDbAction")));
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
