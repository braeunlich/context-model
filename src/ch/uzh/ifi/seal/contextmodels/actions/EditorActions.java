package ch.uzh.ifi.seal.contextmodels.actions;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassKeyPressEvent;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.JavaClassScrollEvent;
import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;

public class EditorActions implements MouseWheelListener, KeyListener {

	private final JavaClass clazz;
	
	public EditorActions(ICompilationUnit compilationUnit) {
		JdtContextModelAdapter model = JdtContextModelAdapter.get();
		clazz = model.getJavaClassFromCompilationUnit(compilationUnit);
	}

	@Override
	public void mouseScrolled(MouseEvent e) {
		if(clazz != null) {
			EventBus.get().fireEvent(new JavaClassScrollEvent(clazz));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(clazz != null) {
			EventBus.get().fireEvent(new JavaClassKeyPressEvent(clazz));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	

}
