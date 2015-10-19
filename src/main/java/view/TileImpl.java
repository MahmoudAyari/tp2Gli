package view;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class TileImpl implements Tile {

	
	private int rank;
	private int size;
	private double windowSize;
	private Button tileButton;
	private long angle;
	private RotateTransition newTransition;
	private ScaleTransition mergeTransition;
	private ParallelTransition winTransition;
	private ScaleTransition lostTransition;
	
	public TileImpl(int size, double windowSize) {
		this.windowSize = windowSize;
		this.size = size;
		this.angle = 0;
		this.rank = 0;
		this.tileButton = new Button("");
		this.tileButton.setMinWidth(windowSize / size - size);
		this.tileButton.setMinHeight(windowSize / size - size);
	}
	
	public Node getTile(){
		return tileButton;
	}
	
	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRank(int rank) {
		// TODO Auto-generated method stub
		
	}

}
