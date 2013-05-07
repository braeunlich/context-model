package ch.uzh.ifi.seal.contextmodels.view.uml;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class ConnectionDecoration extends PolygonDecoration {

	public ConnectionDecoration(int lineWidth) {
		setLineWidth(lineWidth);
		
		if (getLineWidth() < 3) {
			setScale(9, 5);
		} else {
			double logLineWith = getLineWidth() / 2.0;
			setScale(9 * logLineWith, 5 * logLineWith);
		}
	}
	
	public static ConnectionDecoration empty(final int lineWidth) {
		ConnectionDecoration decoration = new ConnectionDecoration(lineWidth);
		decoration.setScale(0, 0);
		return decoration;
	}
	
	public static ConnectionDecoration arrow(final int lineWidth) {
		ConnectionDecoration decoration = new ConnectionDecoration(lineWidth);
		return decoration;
	}
	
	public static ConnectionDecoration diamond(final int lineWidth) {
		ConnectionDecoration decoration = new ConnectionDecoration(lineWidth);
		
		PointList points = new PointList();
		
		points.addPoint(0, 0);
		points.addPoint(-1, 1);
		points.addPoint(-2, 0);
		points.addPoint(-1, -1);
		
		decoration.setTemplate(points);
		
		return decoration;
	}
	
}
