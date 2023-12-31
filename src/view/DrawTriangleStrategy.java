package view;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import view.gui.PaintCanvas;

public class DrawTriangleStrategy implements IStrategy {

	@Override
	public void draw(IShape shape, Graphics2D graphics2d) {
		int[] x  = new int[3];
		//x[0] = shape.startPoint.x;
		x[0] = shape.getStartPoint().x;
		x[1] = shape.getEndPoint().x;
		x[2] = shape.getStartPoint().x;
		int[] y = new int [3];
		y[0] = shape.getStartPoint().y;
		y[1] = shape.getEndPoint().y;
		y[2] = shape.getEndPoint().y;
		int nInts = 3;
		switch(shape.getSST().toString()) {
		case("FILLED_IN"):
			graphics2d.setColor(PaintCanvas.getInstance().map.get(shape.getPrimaryColor()));
			//graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillPolygon(x, y, nInts);
			break;
		case("OUTLINE"):
			graphics2d.setStroke(new BasicStroke(5));
		graphics2d.setColor(PaintCanvas.getInstance().map.get(shape.getPrimaryColor()));
			//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
			graphics2d.drawPolygon(x, y, nInts);
			break;
		case("OUTLINE_AND_FILLED_IN"):
			graphics2d.setColor(PaintCanvas.getInstance().map.get(shape.getPrimaryColor()));
			//graphics2d.setColor(PaintCanvas.map.get(shape.getPrimaryColor()));
			graphics2d.fillPolygon(x, y, nInts);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(PaintCanvas.getInstance().map.get(shape.getSecondaryColor()));
			//graphics2d.setColor(PaintCanvas.map.get(shape.getSecondayColor()));
			graphics2d.drawPolygon(x, y, nInts);
	}

	

}
}