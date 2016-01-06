package view;


import controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewImpl implements View{

	private BorderPane panel;
	private Grid grid;
	private double windowSize;
	private int size;
	private Controller controller;
	
	
	public ViewImpl( int size,double windowSize) {
		super();
		this.windowSize = windowSize;
		panel = new BorderPane();
		setSize(size);
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
		// TODO Auto-generated method stub
		return panel;
	}

	@Override
	public void setTile(int x, int y, int rank) {
		grid.setTile(x, y, rank);
	}
	
	
	
	
}
