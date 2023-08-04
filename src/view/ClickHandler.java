package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.MouseMode;
import model.ShapeColor;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

public class ClickHandler extends MouseAdapter{
	ArrayList<JShape> shapeListCopy = new ArrayList<JShape>();
	 PointClass startPoint = new PointClass(0,0);
	 PointClass endPoint = new PointClass(0,0); 
	 SelectedShapeList selectedShapeList = new SelectedShapeList();
	 DeletedShapeUndoStack undoStack;
	DeletedShapeRedoStack redoStack;
	 
	PaintCanvas paintCanvas;
	 int width;
	int height;
	ShapeList shapeList;
	CommandHistory cmd;
	IUiModule uiModule;
	 ApplicationState appState = new ApplicationState(uiModule);
	IUiModule ui;
	public ClickHandler(ShapeList shapeList, PaintCanvas paintCanvas,  ApplicationState appState, 
			SelectedShapeList selectedShapeList, DeletedShapeUndoStack undoStack, DeletedShapeRedoStack redoStack) {
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.selectedShapeList = selectedShapeList;
		this.undoStack = undoStack;
		this.redoStack = redoStack;
		
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new PointClass(e.getX(), e.getY());
		}	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new PointClass(e.getX(), e.getY());
		final MouseMode mouseMode;
		mouseMode = appState.getActiveMouseMode();
		switch(mouseMode.toString()) {
		case("DRAW"):
		CreateShape createShape = new CreateShape(paintCanvas, shapeList, cmd);
		createShape.run(startPoint, endPoint, appState);
		undoStack.clearList();
		redoStack.clearList();
		
		break;
		case("SELECT"):	
			
		ArrayList<JShape> temp = new ArrayList<JShape>();
		SelectShape boundingBoxShape = new SelectShape(paintCanvas);
		boundingBoxShape.run(selectedShapeList,startPoint, endPoint);
		for (JShape shape : shapeList) {
            if (boundingBoxShape.checkCollision(shape)) {
            	temp.add(shape);
            	}
            }
		selectedShapeList.addAll(temp);
		
		
		break;
		case("MOVE"):
			MoveShape moveShape = new MoveShape(paintCanvas);
			moveShape.run(selectedShapeList, startPoint, endPoint);
			break;
			}
	}
}