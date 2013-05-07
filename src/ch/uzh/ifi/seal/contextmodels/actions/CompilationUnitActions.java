package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.jdt.core.ICompilationUnit;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassClosedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassOpenedEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassSelectedEvent;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.trackers.CompilationUnitTracker;

public class CompilationUnitActions extends CompilationUnitTracker {

	@Override
	public void compilationUnitOpened(ICompilationUnit viewPartInput) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaClass clazz = model.getJavaClassFromCompilationUnit(viewPartInput);
		if(clazz != null) {
			EventBus.get().fireEvent(new JavaClassOpenedEvent(clazz));
		}
	}

	@Override
	public void compilationUnitClosed(ICompilationUnit viewPartInput) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaClass clazz = model.getJavaClassFromCompilationUnit(viewPartInput);
		if(clazz != null) {
			EventBus.get().fireEvent(new JavaClassClosedEvent(clazz));
		}
	}
	
	@Override
	public void compilationUnitBroughtToTop(ICompilationUnit viewPartInput) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		JavaClass clazz = model.getJavaClassFromCompilationUnit(viewPartInput);
		if(clazz != null) {
			EventBus.get().fireEvent(new JavaClassSelectedEvent(clazz));
		}
	}

}