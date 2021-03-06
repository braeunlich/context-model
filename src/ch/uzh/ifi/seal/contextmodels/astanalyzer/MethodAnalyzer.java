package ch.uzh.ifi.seal.contextmodels.astanalyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.internal.corext.callhierarchy.CallHierarchy;
import org.eclipse.jdt.internal.corext.callhierarchy.MethodWrapper;

import ch.uzh.ifi.seal.contextmodels.model.JdtContextModelAdapter;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

@SuppressWarnings("restriction")
public class MethodAnalyzer {

	private final JavaMethod method;
	private JdtContextModelAdapter jdtAdapter;

	public MethodAnalyzer(JavaMethod method) {
		this.method = method;
	}

	public List<JavaMethod> getCallers() {
		jdtAdapter = JdtContextModelAdapter.get();
		
		HashSet<IMethod> jdtMethods = getCallersOf(method.getJdtMethod());
		List<JavaMethod> methods = new ArrayList<>();
		for(IMethod jdtMethod: jdtMethods) {
			JavaMethod caller = jdtAdapter.getMethodInModel(jdtMethod);
			if(caller != null ) {
				jdtAdapter.getJavaCallRealtion(caller, method);
				methods.add(caller);
			}
		}
		return methods;
	}
	
	public List<JavaMethod> getCallees() {
		jdtAdapter = JdtContextModelAdapter.get();
		
		HashSet<IMethod> jdtMethods = getCalleesOf(method.getJdtMethod());
		List<JavaMethod> methods = new ArrayList<>();
		for(IMethod jdtMethod: jdtMethods) {
			JavaMethod callee = jdtAdapter.getMethodInModel(jdtMethod);
			if(callee != null) {
				jdtAdapter.getJavaCallRealtion(method, callee);
				methods.add(callee);
			}
		}
		return methods;
	}
	
	// Code from: http://www.programcreek.com/2011/07/find-all-callers-of-a-method/
	private HashSet<IMethod> getCallersOf(IMethod m) {
		CallHierarchy callHierarchy = CallHierarchy.getDefault();

		IMember[] members = {m};

		MethodWrapper[] methodWrappers = callHierarchy.getCallerRoots(members);
		HashSet<IMethod> callers = new HashSet<IMethod>();
		for (MethodWrapper mw : methodWrappers) {
			MethodWrapper[] mw2 = mw.getCalls(new NullProgressMonitor());
			HashSet<IMethod> temp = getIMethods(mw2);
			callers.addAll(temp);
		}

		return callers;
	}
	
	private HashSet<IMethod> getCalleesOf(IMethod m) {
		CallHierarchy callHierarchy = CallHierarchy.getDefault();

		IMember[] members = {m};

		MethodWrapper[] methodWrappers = callHierarchy.getCalleeRoots(members);
		HashSet<IMethod> callees = new HashSet<IMethod>();
		for (MethodWrapper mw : methodWrappers) {
			MethodWrapper[] mw2 = mw.getCalls(new NullProgressMonitor());
			HashSet<IMethod> temp = getIMethods(mw2);
			callees.addAll(temp);
		}

		return callees;
	}

	private HashSet<IMethod> getIMethods(MethodWrapper[] methodWrappers) {
		HashSet<IMethod> c = new HashSet<IMethod>();
		for (MethodWrapper m : methodWrappers) {
			IMethod im = getIMethodFromMethodWrapper(m);
			if (im != null) {
				c.add(im);
			}
		}
		return c;
	}

	
	private IMethod getIMethodFromMethodWrapper(MethodWrapper m) {
		try {
			IMember im = m.getMember();
			if (im.getElementType() == IJavaElement.METHOD) {
				return (IMethod) m.getMember();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
