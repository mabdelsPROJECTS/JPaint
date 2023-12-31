package view;

import java.util.ArrayList;
import java.util.Iterator;

import view.gui.PaintCanvas;

public class ShapeList  implements Iterable<IShape>, IShapeListSubject   {
	
	
	private ArrayList<IShapeListObserver> observers;
	private final ArrayList<IShape> myList;
	//private final ArrayList<Object> groupList;
	PaintCanvas paintCanvas;
	
	
	
	public ShapeList() {
		myList = new ArrayList<IShape>();
		observers = new ArrayList<IShapeListObserver>();
		//groupList = new ArrayList<Object>();
		}
	
	public void addShape(IShape shape) {
		myList.add(shape);
		notifyObservers();
		//System.out.println("Notify for add ran");
		///paintCanvas.repaint();
		}
	
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	public int size() {
		return myList.size();
		
	}

	public void removeShape(IShape shape) {
		myList.remove(shape);
		notifyObservers();
		//System.out.println("Notfiy for remove ran");
		//paintCanvas.repaint();
		}


	@Override
	public Iterator<IShape> iterator() {
		return myList.iterator();
	}
	

	
	public void addAll(ArrayList<IShape> temp) {
		this.myList.addAll(temp);
	}

	public void removeAll(ArrayList<IShape> temp) {
		this.myList.removeAll(temp);
	}
	@Override
	public void registerObserver(IShapeListObserver observer) {
		observers.add(observer);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		for(IShapeListObserver observer: observers) {
			observer.update(this);
		}
	}
	
	public void clearList() {
		myList.clear();
	}
	
	
		
	
}
