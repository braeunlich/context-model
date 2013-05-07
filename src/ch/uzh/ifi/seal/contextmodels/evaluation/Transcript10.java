package ch.uzh.ifi.seal.contextmodels.evaluation;

import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaMethodSelectedEvent;
/**
 * Transcript 10
 * 
 * Jpass
 * 
 * @author chb
 *
 */
public class Transcript10 extends AbstractTranscriptRunner {
	
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
		
	}

	

}
