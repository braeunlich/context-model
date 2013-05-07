package ch.uzh.ifi.seal.contextmodels.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Composite;

import ch.uzh.ifi.seal.contextmodels.view.uml.CallerMethodFigure;
import ch.uzh.ifi.seal.contextmodels.view.uml.ClassFigure;

public class ContextModelViewLayouter {

	/*
	 * LAYOUT:
	 * 
	 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	 * M[Random classes]M[Parent classes]M[Random classes]M
	 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	 * M[Callers       ]M[Active Class  ]M[Calees        ]M
	 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	 * M[Random classes]M[Child classes ]M[Random classes]M
	 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM 
	 *
	 * []:   					compartment
	 * Random classes: 			classes with no or ??? connection to the active class.
	 * Parent classes: 			classes which are extended by the active class.
	 * Child classes: 			classes which extend the active class.
	 * Callers: 				If the active element is a method: methods that call the active method.
	 * Calees: 					If the active element is a method: methods that are called by the active method.
	 * M: 	MARGIN
	 * 
	 */
	
	private final Composite parent;
	
	/* minimal margin between objects*/
	private final static int MARGIN = 10;
	private final static int CALLER_MARGIN = 5;
	
	private int numberOfTopClasses = 0;
	private int numberOfBottomClasses = 0;
	
	public void reset() {
		numberOfTopClasses = 0;
		numberOfBottomClasses = 0;
	}
	
	public ContextModelViewLayouter(final Composite parent) {
		this.parent = parent;
	}
	
	/**
	 * Returns the position and size rectangle for the active class.
	 * 
	 * The active class will be positioned in the center of the view.
	 * 
	 * @param figure
	 * @return
	 */
	public Rectangle getActiveClassRectangle(ClassFigure figure) {
		Rectangle bounds = getActiveClassBounds();
		
		int width = figure.getPreferredSize().width;
		int height = figure.getPreferredSize().height;
		
		width = bounds.width < width ? bounds.width : width;
		height = bounds.height < height ? bounds.height : height;
		
		int x = bounds.x + (bounds.width - width) / 2;
		int y = bounds.y + (bounds.height - height) / 2;
		
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getParentClassRectangle(ClassFigure parentClassFigure) {
		Rectangle bounds;
		
		if(numberOfTopClasses == 0) {
			bounds = getTopMiddleRectangle();
		} else if(numberOfTopClasses == 1) {
			bounds = getTopLeftRectangle();
		} else if(numberOfTopClasses == 2) {
			bounds = getTopRightRectangle();
		} else {
			return null;
		}
		
		++numberOfTopClasses;
		
		return fitClassFigureToBounds(parentClassFigure, bounds);
	}
	

	public Rectangle getChildClassRectangle(ClassFigure childClassFigure) {
		Rectangle bounds;
		
		if(numberOfBottomClasses == 0) {
			bounds = getBottomMiddleRectangle();
		} else if(numberOfBottomClasses == 1) {
			bounds = getBottomLeftRectangle();
		} else if(numberOfBottomClasses == 2) {
			bounds = getBottomRightRectangle();
		} else {
			return null;
		}
		
		++numberOfBottomClasses;
		
		return fitClassFigureToBounds(childClassFigure, bounds);
	}
	
	private Rectangle fitClassFigureToBounds(ClassFigure classFigure, Rectangle bounds) {
		int width = bounds.width < classFigure.getPreferredSize().width ? bounds.width : classFigure.getPreferredSize().width;
		int height = bounds.height < classFigure.getPreferredSize().height ? bounds.height : classFigure.getPreferredSize().height;
		int x = bounds.x + (bounds.width -  classFigure.getPreferredSize().width) / 2;
		int y = bounds.y + (bounds.height -  classFigure.getPreferredSize().height) / 2;
		
		return new Rectangle(x, y, width, height);
	}
	
	private Rectangle getTopRightRectangle() {
		int x = 3 * MARGIN + 2* getBoundsWidth();
		int y = MARGIN;
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}

	private Rectangle getTopLeftRectangle() {
		int x = MARGIN;
		int y = MARGIN;
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}

	private Rectangle getTopMiddleRectangle() {
		int x = 2 * MARGIN + getBoundsWidth();
		int y = MARGIN;
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}
	
	private Rectangle getBottomRightRectangle() {
		int x = 3 * MARGIN + 2 * getBoundsWidth();
		int y = 3 * MARGIN + 2 * getBoundsHeight();
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}

	private Rectangle getBottomLeftRectangle() {
		int x = MARGIN;
		int y = 3 * MARGIN + 2 * getBoundsHeight();
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}

	private Rectangle getBottomMiddleRectangle() {
		int x = 2 * MARGIN + getBoundsWidth();
		int y = 3 * MARGIN + 2 * getBoundsHeight();
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * Returns the position and size rectangle for callers.
	 * 
	 * The callers will be positioned left of the center of the view.
	 * 
	 * @param list of callers
	 * @return
	 */
	public List<Rectangle> getCallerRectangles(List<CallerMethodFigure> callerFigures) {
		List<Rectangle> rectangles = new ArrayList<>();

		int maxCallers = getMaximumNumberOfCallers();
		int numberOfCallers = callerFigures.size() > maxCallers ? maxCallers : callerFigures.size();
		
		int figureHeight = CallerMethodFigure.HEIGHT;
		
		int yOffset = ((maxCallers - numberOfCallers) * (figureHeight + CALLER_MARGIN))/2; 
		
		int x = MARGIN;
		int y = getCallersBounds().y + yOffset;
		
		for(int i=0; i<numberOfCallers; i++) {
			int preferredWidth = callerFigures.get(i).getPreferredSize().width;
			
			int width  = preferredWidth > getCallersBounds().width ? getCallersBounds().width : preferredWidth;
			int height = callerFigures.get(i).getPreferredSize().height;
			
			rectangles.add(new Rectangle(x, y, width, height));
			y += figureHeight + CALLER_MARGIN;
		}
		
		return rectangles;
	}
	
	/**
	 * Returns the position and size rectangle for calees.
	 * 
	 * The callers will be positioned left of the center of the view.
	 * 
	 * @param list of callers
	 * @return
	 */
	public List<Rectangle> getCalleeRectangles(List<CallerMethodFigure> caleeFigures) {
		List<Rectangle> rectangles = getCallerRectangles(caleeFigures);
		
		int x = 3 * MARGIN + 2 * getBoundsWidth();
		
		for(Rectangle rectangle: rectangles) {
			rectangle.setX(x);
		}
		return rectangles;
	}
	

	/**
	 * Get the bounds height for one of the 9 rectangles.
	 * @return
	 */
	private int getBoundsHeight() {
		return (getHeight() - 4 * MARGIN) / 3;
	}

	/**
	 * Get the bounds width for one of the 9 rectangles.
	 * @return
	 */
	private int getBoundsWidth() {
		return (getWidth() - 4 * MARGIN) / 3;
	}
	
	/**
	 * returns the maximum expansion of the active class. 
	 * 
	 * @return
	 */
	private Rectangle getActiveClassBounds() {
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		int x = width + 2 * MARGIN;
		int y = height + 2 * MARGIN;
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * returns the maximum expansion of the callers 
	 * 
	 * @return
	 */
	private Rectangle getCallersBounds() {
		int width = getBoundsWidth();
		int height = getBoundsHeight();
		int x = width + MARGIN;
		int y = height + 2 * MARGIN;
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * 
	 * @return the maximum number of caller figures that fit into the callers bounds.
	 */
	public int getMaximumNumberOfCallers() {
		int totalHeight = getCallersBounds().height; 
		int figureHeight = CallerMethodFigure.HEIGHT;
		return (totalHeight - CALLER_MARGIN) / (figureHeight + CALLER_MARGIN);
	}
	
	
	private int getWidth() {
		return parent.getBounds().width;
	}
	
	private int getHeight() {
		 return parent.getBounds().height;
	}


	

	

	
	
}
