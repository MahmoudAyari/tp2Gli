package view;


import controller.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewImpl implements View{

	private BorderPane panel;
	private Grid grid;
	private double windowSize;
	private int size;
	private Controller controller;
	private BooleanProperty win;
	private BooleanProperty lost;
	
	public ViewImpl( int size,double windowSize) {
		super();
		this.windowSize = windowSize;
		panel = new BorderPane();
		setSize(size);
		win = new SimpleBooleanProperty();
		lost = new SimpleBooleanProperty();
	}

	@Override
	public void setSize(int size) {
		this.size=size;
		grid = new GridImpl(size, windowSize);
		panel.setCenter(grid.getGrid());
	}

	@Override
	public void setController(Controller controller) {
		this.controller=controller;
		grid.move(controller);
	}

	@Override
	public Parent getPanel() { 
		return panel;
	}

	@Override
	public void setTile(int x, int y, int rank) {
		grid.setTile(x, y, rank);
	}

	@Override
	public void setGamerWon(boolean win) {
		this.win.set(win);
	 }

	@Override
	public void setGamerLost(boolean lost) {
		this.lost.set(lost);
		
	}

	@Override
	public GUITile getTile(int x, int y) {
		return grid.getTile(x, y);
		
	}
	
	
	
	
}
