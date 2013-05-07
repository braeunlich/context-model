package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class DiamondConnectionDecoration extends PolygonDecoration {

	PointList points = new PointList();
	
	public DiamondConnectionDecoration() {
		
		points.addPoint(0, 0);
		points.addPoint(-1, 1);
		points.addPoint(-2, 0);
		points.addPoint(-1, -1);
		
		setTemplate(points);
	}

	
}
