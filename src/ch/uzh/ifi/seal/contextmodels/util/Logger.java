package ch.uzh.ifi.seal.contextmodels.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Status;

import ch.uzh.ifi.seal.contextmodels.Activator;

/**
 * 
 * Wrapper class for the PDE logging facilities with convenience methods for different 
 * logging severities.
 * 
 * @author Christoph Braeunlich
 *
 */
public class Logger {
	
	private static LogWriter writer;
	
	public static void setTesting() {
		writer = new TestLogWriter();
	}
	
	private static LogWriter getWriter() {
		if(writer == null) {
			writer = new EclipseLogWriter(Activator.getDefault().getLog());
		}
		return writer;
	}
	
	/**
	 * Logs the given message with Severity {@code Status.INFO}. A status is distributed 
	 * to the Plug-in's log listeners installed on this log and then to the log listeners 
	 * installed on the platform.
	 *
	 * @param message the message to log
	 */
	public static void info(String message) {
		getWriter().writeInfo(message);
	}

	/**
	 * Logs the given message with Severity {@code Status.WARNING}. A status is distributed 
	 * to the Plug-in's log listeners installed on this log and then to the log listeners 
	 * installed on the platform.
	 *
	 * @param message the message to log
	 */
	public static void warning(String message) {
		getWriter().writeWarning(message);
	}
	
	/**
	 * Logs the given message with Severity {@code Status.ERROR}. A status is distributed 
	 * to the Plug-in's log listeners installed on this log and then to the log listeners 
	 * installed on the platform.
	 *
	 * @param message the message to log
	 */
	public static void error(String message) {
		getWriter().wirteError(message);
	}

	public interface LogWriter {
		
		public void writeInfo(String message);
		public void writeWarning(String message);
		public void wirteError(String message);
		
	}
	
	public static class EclipseLogWriter implements LogWriter {

		private final ILog log;
		private final String pluginId = Activator.PLUGIN_ID;
		
		public EclipseLogWriter(ILog log) {
			this.log = log;
		}
		
		@Override
		public void writeInfo(String message) {
			log.log(new Status(Status.INFO, pluginId, message));
		}

		@Override
		public void writeWarning(String message) {
			log.log(new Status(Status.WARNING, pluginId, message));
		}

		@Override
		public void wirteError(String message) {
			log.log(new Status(Status.ERROR, pluginId, message));
		}
		
	}
	
	public static class TestLogWriter implements LogWriter {

		@Override
		public void writeInfo(String message) {
			System.out.println("III - " + message);
		}

		@Override
		public void writeWarning(String message) {
			System.out.println("WWW - " + message);
		}

		@Override
		public void wirteError(String message) {
			System.err.println("EEE - " + message);
		}
		
	}
	
}
