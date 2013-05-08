package ch.uzh.ifi.seal.contextmodels.view;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.Observer;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaInheritance;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaRelation;
import ch.uzh.ifi.seal.contextmodels.view.layout.CellCoordinate;
import ch.uzh.ifi.seal.contextmodels.view.layout.CellLayout;
import ch.uzh.ifi.seal.contextmodels.view.layout.MethodCell;
import ch.uzh.ifi.seal.contextmodels.view.uml.CallerMethodFigure;
import ch.uzh.ifi.seal.contextmodels.view.uml.MethodLabel;

public class ContextModelView extends ViewPart {

	public static final String ID = "ch.uzh.ifi.seal.contextmodels.view.contextmodelview";

	private Figure rootFigure;
	private XYLayout swtLayout;

	private CellLayout layout;

	@Override
	public void createPartControl(Composite parent) {

		Canvas canvas = createDiagram(parent);
		canvas.setLayoutData(new GridData(GridData.FILL_BOTH));

		layout = new CellLayout(parent, rootFigure, swtLayout);

		ContextModel.get().registerListener(new Observer<ContextModel>() {
			@Override
			public void update(ContextModel observable) {
				synchronizeWithModel();
			}

		});
		
		parent.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				synchronizeWithModel();
			}
		});
	}

	private void synchronizeWithModel() {
		layout.reset();
		showClasses();
	}

	private void showClasses() {
		JavaClass activeClass = ContextModel.get().getActiveClass();

		if (activeClass != null) {
			CellCoordinate coordinates = new CellCoordinate(0, 0);
			layout.addActiveClass(coordinates, activeClass);
			showParentClasses(activeClass, coordinates);
			showChildClasses(activeClass, coordinates);
			
//			if (model.getActiveElement() instanceof JavaMethod) {
//			showCallers((JavaMethod) model.getActiveElement(),
//					activeClassFigure.getActiveMethodLabel());
//			showCallees((JavaMethod) model.getActiveElement(),
//					activeClassFigure.getActiveMethodLabel());
//		}
			if(ContextModel.get().getActiveElement() instanceof JavaMethod) {
				
				MethodLabel caleeFigure = layout.getActiveClassFigure().getActiveMethodLabel();
				showCallers(((JavaMethod)ContextModel.get().getActiveElement()), coordinates, caleeFigure);
			}
		}
	}
	
	private void showChildClasses(JavaClass clazz, CellCoordinate parentCoordinates) {
		ContextModel model = ContextModel.get();
		List<JavaRelation> relations = model.getRelevantRelations();
		
		for (JavaRelation relation : relations) {
			if (relation instanceof JavaInheritance
					&& ((JavaInheritance) relation).getParentElement().equals(clazz)) {
				showChildClassAndRelation(((JavaInheritance) relation), parentCoordinates);
			}
		}
	}
	
	private void showChildClassAndRelation(JavaInheritance javaInheritance,
			CellCoordinate parentCoordinates) {
		
		CellCoordinate childCoordinate = layout.getFreeChildCoordinates(parentCoordinates);
		if(childCoordinate == null) {
			return;
		}
		
		JavaClass childClass = (JavaClass) javaInheritance.getChildElement();
		
		layout.addClass(childCoordinate, childClass);
		layout.addInheritance(childCoordinate, parentCoordinates);

		showChildClasses(childClass, childCoordinate);
	}

	private void showParentClasses(JavaClass clazz, CellCoordinate childCoordinates) {
		ContextModel model = ContextModel.get();
		List<JavaRelation> relations = model.getRelevantRelations();
		
		for (JavaRelation relation : relations) {
			if (relation instanceof JavaInheritance
					&& ((JavaInheritance) relation).getChildElement().equals(clazz)) {
				showParentClassAndRelation(((JavaInheritance) relation), childCoordinates);
			}
		}
		
	}
	
	private void showParentClassAndRelation(JavaInheritance javaInheritance, CellCoordinate childCoordinate) {
		CellCoordinate parentCoordinate = layout.getFreeParentCoordinates(childCoordinate);
		if(parentCoordinate == null) {
			return;
		}
		
		JavaClass parentClass = (JavaClass) javaInheritance.getParentElement();
		
		layout.addClass(parentCoordinate, parentClass);
		layout.addInheritance(childCoordinate, parentCoordinate);

		showParentClasses(parentClass, parentCoordinate);
		
	}
	
	private void showCallers(JavaMethod activeMethod, CellCoordinate coordinates, MethodLabel calleeMethodLabel) {
		CellCoordinate callerCoordinate = layout.getFreeCallerCoordinate(coordinates);
		MethodCell cell = layout.getMethodCell(callerCoordinate);
		if(cell == null) {
			return;
		}
		
		for (JavaMethod method : ContextModel.get().getCallers(activeMethod)) {
			CallerMethodFigure callerFigure = cell.addCallerMethod(method);
			layout.addCall(callerFigure.getMethodLabel(), calleeMethodLabel);
		}

	}
	
	


//
//	private void showActiveClass(JavaClass clazz) {
//		ContextModel model = ContextModel.get();
//
//		activeClassFigure = new ClassFigure(clazz);
//		rootFigure.add(activeClassFigure);
//		layout.setConstraint(activeClassFigure,
//				layouter.getActiveClassRectangle(activeClassFigure));
//
//		if (model.getActiveElement() instanceof JavaMethod) {
//			showCallers((JavaMethod) model.getActiveElement(),
//					activeClassFigure.getActiveMethodLabel());
//			showCallees((JavaMethod) model.getActiveElement(),
//					activeClassFigure.getActiveMethodLabel());
//		}
//	}
//
//	private void showCallers(JavaMethod activeMethod,
//			MethodLabel activeMethodFigure) {
//		List<CallerMethodFigure> callerFigures = new ArrayList<>();
//		for (JavaMethod method : ContextModel.get().getCallers(activeMethod)) {
//			callerFigures.add(new CallerMethodFigure(method));
//		}
//
//		List<Rectangle> callerPositions = layouter
//				.getCallerRectangles(callerFigures);
//
//		for (int i = 0; i < callerPositions.size(); i++) {
//			CallerMethodFigure figure = callerFigures.get(i);
//			Rectangle rectangle = callerPositions.get(i);
//
//			rootFigure.add(figure);
//			layout.setConstraint(figure, rectangle);
//
//			rootFigure.add(connectCaller(figure.getMethodLabel(),
//					activeMethodFigure));
//		}
//	}
//
//	private void showCallees(JavaMethod activeMethod,
//			MethodLabel activeMethodFigure) {
//		List<CallerMethodFigure> calleeFigures = new ArrayList<>();
//		for (JavaMethod method : ContextModel.get().getCallees(activeMethod)) {
//			calleeFigures.add(new CallerMethodFigure(method));
//		}
//
//		List<Rectangle> calleePositions = layouter
//				.getCalleeRectangles(calleeFigures);
//
//		for (int i = 0; i < calleePositions.size(); i++) {
//			CallerMethodFigure figure = calleeFigures.get(i);
//			Rectangle rectangle = calleePositions.get(i);
//
//			rootFigure.add(figure);
//			layout.setConstraint(figure, rectangle);
//
//			rootFigure.add(connectCaller(activeMethodFigure,
//					figure.getMethodLabel()));
//		}
//	}
//
//	private PolylineConnection connectCaller(MethodLabel caller,
//			MethodLabel calee) {
//		PolylineConnection connection = new PolylineConnection();
//		connection.setSourceAnchor(caller.getRightAnchor());
//		connection.setTargetAnchor(calee.getLeftAnchor());
//		return connection;
//	}
//
//	private PolylineConnection connectInheritance(ClassFigure child,
//			ClassFigure parent) {
//		PolylineConnection connection = new PolylineConnection();
//		connection.setSourceAnchor(new ChopboxAnchor(child));
//		connection.setTargetAnchor(new ChopboxAnchor(parent));
//
//		PolygonDecoration decoration = new PolygonDecoration();
//		decoration.setFill(true);
//		decoration.setBackgroundColor(new Color(Display.getCurrent(), 255, 255,
//				255));
//		decoration.setScale(8, 6);
//		connection.setTargetDecoration(decoration);
//
//		return connection;
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}

	private Canvas createDiagram(Composite parent) {

		rootFigure = new Figure();
		rootFigure.setFont(parent.getFont());
		swtLayout = new XYLayout();
		rootFigure.setLayoutManager(swtLayout);

		// Create a canvas to display the root figure
		Canvas canvas = new Canvas(parent, SWT.DOUBLE_BUFFERED);
		canvas.setBackground(ColorConstants.white);
		LightweightSystem lws = new LightweightSystem(canvas);
		lws.setContents(rootFigure);

		return canvas;
	}

}
