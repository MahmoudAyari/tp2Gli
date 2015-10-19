package view;


import javafx.scene.layout.BorderPane;

public class ViewImpl implements View{

	private BorderPane panel;
	private Grid grid;
	private double windowSize;
	private int size;
	
	public ViewImpl(double windowSize, int size) {
		super();
		this.windowSize = windowSize;
		this.size = size;
	}
	
	
	
	
}
