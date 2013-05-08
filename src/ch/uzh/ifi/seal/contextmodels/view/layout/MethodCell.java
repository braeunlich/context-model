package ch.uzh.ifi.seal.contextmodels.view.layout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;
import ch.uzh.ifi.seal.contextmodels.view.uml.CallerMethodFigure;
import ch.uzh.ifi.seal.contextmodels.view.uml.MethodFigure;

public class MethodCell extends Cell {

	private static final int CALLER_MARGIN = 5;
	private List<MethodSubCell> subCells = new ArrayList<>();

	public MethodCell(CellLayout layout, CellCoordinate coordinates) {
		super(layout, coordinates);
	}

	@Override
	public void layoutNode() {
		for(int i=0; i<subCells.size(); i++) {
			subCells.get(i).setBounds(getMethodBounds(i));
			subCells.get(i).layoutNode();
		}
	}

	@Override
	public Rectangle getRectangle() {
		return getBounds();
	}
	
	public void clear() {
		for(MethodSubCell subCell: subCells) {
			subCell.clearFigure();
		}
		subCells.clear();
	}
	
	public CallerMethodFigure addCallerMethod(JavaMethod method) {
		Rectangle bounds = getMethodBounds(subCells.size());
		MethodSubCell subCell = new MethodSubCell(layout, bounds);
		CallerMethodFigure figure = new CallerMethodFigure(method);
		subCell.setMethodFigure(figure);
		subCells.add(subCell);
		return figure;
	}

	public Rectangle getMethodBounds(final int methodIndex) {
		int height = CallerMethodFigure.HEIGHT;
		int width = getBounds().width;
		int x = getBounds().x;
		int y = getYPosOfMiddleMethod();
		
		if(methodIndex % 2 == 0) {
			y += (methodIndex / 2) * (CallerMethodFigure.HEIGHT + CALLER_MARGIN);
		} else {
			y -= (methodIndex / 2 + 1) * (CallerMethodFigure.HEIGHT + CALLER_MARGIN);
		}
		
		return new Rectangle(x, y, width, height);
	}
	
	private int getYPosOfMiddleMethod() {
		return getBounds().y + getBounds().height / 2 - CallerMethodFigure.HEIGHT / 2;
	}
}
