package ch.uzh.ifi.seal.contextmodels.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import ch.uzh.ifi.seal.contextmodels.eventmodel.EventBus;
import ch.uzh.ifi.seal.contextmodels.eventmodel.events.DiagramClassClickEvent;
import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.Observer;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaComposition;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaRelation;
import ch.uzh.ifi.seal.contextmodels.util.JdtUtil;
import ch.uzh.ifi.seal.contextmodels.view.uml.CalleeGraphNode;
import ch.uzh.ifi.seal.contextmodels.view.uml.CallerGraphNode;
import ch.uzh.ifi.seal.contextmodels.view.uml.ClassGraphNode;
import ch.uzh.ifi.seal.contextmodels.view.uml.JavaCallConnection;
import ch.uzh.ifi.seal.contextmodels.view.uml.JavaCompositionConnection;
import ch.uzh.ifi.seal.contextmodels.view.uml.JavaInheritanceConnection;
import ch.uzh.ifi.seal.contextmodels.view.uml.JavaRelationConnection;

public class DiagramView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "ch.uzh.ifi.seal.contextmodels.view.DiagramView";

	private Graph graph;
	private List<GraphNode> nodes = new ArrayList<>();
	private List<JavaRelationConnection> relations = new ArrayList<>();

	public DiagramView() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		graph = new Graph(parent, SWT.NONE);
		graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(), false);
		graph.setNodeStyle(ZestStyles.NODES_NO_LAYOUT_ANIMATION);

		synchronizeWithModel();

		graph.addSelectionListener(createSelectionListener());

		ContextModel.get().registerListener(new Observer<ContextModel>() {
			@Override
			public void update(ContextModel observable) {
				synchronizeWithModel();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}

	/**
	 * Reloads the existing classes from the Eclipse Workspace and displays
	 * them.
	 */
	public void refresh() {
		ContextModel.get().synchronizeWithWorkspace();
		synchronizeWithModel();
	}

	private SelectionAdapter createSelectionListener() {
		return new GraphSelectionListener();
	}

	private void onClassSelected(JavaClass clazz) {
		JdtUtil.openClassInJavaEditor(clazz.getFullyQualifiedName());
		EventBus.get().fireEvent(new DiagramClassClickEvent(clazz));
	}

	private void synchronizeWithModel() {
		removeNodesAndRelations();
		for (JavaClass clazz : ContextModel.get().getRelevantClasses()) {
			addNode(clazz);
		}

		for (JavaRelation realtion : ContextModel.get().getRelevantRelations()) {
			addRealtion(realtion);
		}

		JavaElement activeElement = ContextModel.get().getActiveElement();

		if (activeElement instanceof JavaMethod) {
			addCallerNodes((JavaMethod) activeElement);
		}

		if (!graph.isDisposed()) {
			graph.applyLayout();
		}
	}

	private void addNode(JavaClass clazz) {
		// DiagramView is disposed before the JavaEditor. JavaEditor fires an
		// JavaElementClosedEvent which could trigger addNode an a disposed
		// DiagramView.
		if (!graph.isDisposed()) {
			nodes.add(new ClassGraphNode(graph, clazz));
		}
	}

	private void addCallerNodes(JavaMethod method) {
		if (!graph.isDisposed()) {
			CallerGraphNode callerNode = new CallerGraphNode(graph, method);
			CalleeGraphNode calleeNode = new CalleeGraphNode(graph, method);
			
			nodes.add(callerNode);
			nodes.add(calleeNode);
			GraphNode activeMethodNode = getNodeByClass(method.getJavaClass());
			if (activeMethodNode != null) {
				JavaCallConnection connection1 = new JavaCallConnection(graph, callerNode, activeMethodNode);
				connection1.setCurveDepth(-10);
				connection1.setConnectionStyle(ZestStyles.CONNECTIONS_DASH);
				JavaCallConnection connection2 = new JavaCallConnection(graph, callerNode, activeMethodNode);
				JavaCallConnection connection3 = new JavaCallConnection(graph, callerNode, activeMethodNode);
				connection3.setCurveDepth(10);
				relations.add(connection1);
				relations.add(connection2);
				relations.add(connection3);
				
				JavaCallConnection connection4 = new JavaCallConnection(graph, activeMethodNode, calleeNode);
				connection4.setCurveDepth(-10);
				connection4.setConnectionStyle(ZestStyles.CONNECTIONS_DASH);
				JavaCallConnection connection5 = new JavaCallConnection(graph, activeMethodNode, calleeNode);
				JavaCallConnection connection6 = new JavaCallConnection(graph, activeMethodNode, calleeNode);
				connection6.setCurveDepth(10);
				relations.add(connection4);
				relations.add(connection5);
				relations.add(connection6);
			}
		}
	}

	private void addRealtion(JavaRelation relation) {
		if (graph.isDisposed()) {
			return;
		}

		ClassGraphNode source = getNodeByClass(relation.getSourceElement());
		ClassGraphNode destination = getNodeByClass(relation
				.getDestinationElement());

		JavaRelationConnection connection;

		if (relation instanceof JavaInheritance) {
			connection = new JavaInheritanceConnection(graph, source,
					destination);
		} else if (relation instanceof JavaComposition) {
			JavaField field = ((JavaComposition) relation).getField();
			connection = new JavaCompositionConnection(graph, source,
					destination, field);
		} else {
			return;
		}

		connection.setRelevance(relation.getRelevance());

		relations.add(connection);
	}

	private ClassGraphNode getNodeByClass(JavaElement clazz) {
		if (!(clazz instanceof JavaClass)) {
			return null;
		}

		for (GraphNode node : nodes) {
			if (node instanceof ClassGraphNode) {
				if (((ClassGraphNode) node).getJavaClass().equals(clazz)) {
					return (ClassGraphNode) node;
				}
			}
		}
		return null;
	}

	private void removeNodesAndRelations() {
		for (JavaRelationConnection relation : relations) {
			relation.dispose();
		}

		for (GraphNode node : nodes) {
			node.dispose();
		}

		relations.clear();
		nodes.clear();
	}

	private final class GraphSelectionListener extends SelectionAdapter {

		public void widgetSelected(SelectionEvent e) {
			@SuppressWarnings("rawtypes")
			List selection = ((Graph) e.widget).getSelection();
			if (selection.size() > 0) {
				if (selection.get(0) instanceof GraphNode) {
					graphNodeSelected((GraphNode) selection.get(0));
				} else if (selection.get(0) instanceof GraphConnection) {
					graphConnectionSelected((GraphConnection) selection.get(0));
				}
			}
		}

		private void graphNodeSelected(GraphNode node) {
			if (node instanceof ClassGraphNode) {
				onClassSelected(((ClassGraphNode) node).getJavaClass());
			}
		}

		private void graphConnectionSelected(GraphConnection connection) {
			if (connection instanceof JavaCompositionConnection) {
				JavaField field = ((JavaCompositionConnection) connection)
						.getField();
				JdtUtil.openJavaElementInJavaEditor(field.getJdtField());
			}
		}
	}

}