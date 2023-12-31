package view;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
	
	public PointClass getStartPoint();
	public PointClass getEndPoint();

	ShapeColor getPrimaryColor();
	
	ShapeType getShapeType();

	ShapeShadingType getSST();

	ShapeColor getSecondaryColor();

	int getWidth();

	int getHeight();

	void draw(Graphics2D graphics2d);

	public IShape paste();

	void move(int deltaX, int deltaY);

	void delete(ShapeList shapeList);
	
	//void addShape(IPointShape shape);
}
