package view;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;

@SuppressWarnings("restriction")
public class TileImpl extends Button implements Tile {

	
	private int rank;
	private int size;
	private double windowSize;
	private Button tile;
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
		this.tile = new Button("");
		this.tile.setMinWidth(windowSize / size - size);
		this.tile.setMinHeight(windowSize / size - size);
	}
	
	public Node getTile(){
		return tile;
	}
	
	@Override
	public int getRank() {
		return rank;
	}

	@Override
	public void setRank(int rank) {
		this.rank=rank;
		if(rank==0){
			this.tile = new Button("");
		}
		
	}

}
