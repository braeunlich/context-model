package ch.uzh.ifi.seal.contextmodels.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public abstract class AbstractTranscriptRunner implements TranscriptRunner {

	public class JavaClassNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -4599248287037074113L;
		private final String className;

		public JavaClassNotFoundException(String className) {
			this.className = className;
		}

		@Override
		public String getMessage() {
			return "Class not found: " + className;
		}

	}

	public class MethodNotFoundExcpetion extends RuntimeException {

		private static final long serialVersionUID = 2813958300919061349L;
		private final String className;
		private final String methodName;

		public MethodNotFoundExcpetion(String className, String methodName) {
			this.className = className;
			this.methodName = methodName;
		}

		@Override
		public String getMessage() {
			return "Method not found: " + className + "." + methodName;
		}

	}

	protected EventBus bus = EventBus.get();
	protected DeveloperModel developerModel;
	protected NavigationHistory history;
	private String output;
	private int step;
	private List<Event> eventQueue = new ArrayList<Event>();
	
	
	@Override
	public void run() {
		int end = step + 10;
		if(end > eventQueue.size()) {
			end = eventQueue.size();
		}
		
		while(step < end) {
			issueEvent(eventQueue.get(step));
		}
		
		System.out.println(output);
	}

	@Override
	public void prepare() {
		output = "Step, Precision, Recall, isRevisit, categorizedAsRelevant, contextModelRelevantClasses, contextModelRelevantMethods, contextModelRelevantFields, element\n";
		step = 0;
		developerModel = buildDeveloperModel();
		history = new NavigationHistory();
		
		try {
			runTranscript();
		} catch (RuntimeException | InterruptedException e ) {
			Logger.warning(e.getMessage());
		} finally {
			System.out.println(output);
		}
	}
	
	private void issueEvent(Event event) {
		bus.fireEvent(event);
		output += ++step + ", " + developerModel.getPrecision() + ", " + developerModel.getRecall() + ", ";
		output += (history.isRevisit()?"1":"0") + ", " + (history.isRelevantInContextModel()?"1":"0") + ", ";
		output += developerModel.numberOfRetrievedClasses() + ", " + developerModel.numberOfRetrievedMethods() + ", ";
		output += developerModel.numberOfRetrievedFields() + ", ";
		output += history.lastElement + "\n";
		
		System.out.println("step " + step + ", element " + history.lastElement);
	}
	
	protected abstract void runTranscript() throws InterruptedException;
	
	protected abstract DeveloperModel buildDeveloperModel();
	
	protected void fire(Event event) {
		try {
			eventQueue.add(event);
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
	}

	protected void fire(Event event, int times) throws InterruptedException {
		for (int i = 0; i < times; i++) {
			fire(event);
		}
	}

	protected JavaClass clazz2(String className) {
		ICompilationUnit cu = JdtUtil.lookUpCompilationUnit(className);
		JavaClass clazz = JdtContextModelAdapter.get()
				.getJavaClassFromCompilationUnit(cu);
		if (clazz == null) {
			throw new JavaClassNotFoundException(className);
		}

		return clazz;
	}
	
	protected abstract String getProjectName();
	
	private IJavaProject javaProject;
	
	private IJavaProject getJavaProject() {
		if(javaProject == null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(getProjectName());
			javaProject = JavaCore.create(project);
		}
		return javaProject;
	}
	
	protected JavaClass clazz(String className) {
		JavaClass clazz = null;
		try {
			clazz = JdtContextModelAdapter.get()
			.getJavaClass(getJavaProject().findType(className));
			
			if(clazz == null) {
				throw new JavaClassNotFoundException(className);
			}
		} catch (Exception e) {
			throw new JavaClassNotFoundException(className);
		}
		
		return clazz;
		
	}

	protected JavaMethod method(String className, String methodName) {
		for (JavaMethod method : clazz(className).getMethods()) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		throw new MethodNotFoundExcpetion(className, methodName);
	}

}
