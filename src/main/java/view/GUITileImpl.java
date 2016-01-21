package view;



import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;
@SuppressWarnings("restriction")
public class GUITileImpl  implements GUITile {
	private static final String CSS = "";
	private final static Color[] COLOR = { Color.WHITE, Color.DEEPPINK, Color.MEDIUMSPRINGGREEN, Color.CYAN,
			Color.ROYALBLUE, Color.MIDNIGHTBLUE, Color.DARKCYAN, Color.BLUE, Color.DEEPSKYBLUE, Color.STEELBLUE,
			Color.LIGHTSKYBLUE, Color.GOLD, };
	private int rank;
	private int size;
	private double windowSize;
	private Button tile;
	private long angle;
	

	
	public GUITileImpl(int size, double windowSize) {
		
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
			
			this.tile.setText("");
			this.tile.setBackground(
					new Background(new BackgroundFill(COLOR[0], new CornerRadii(5), Insets.EMPTY))
				);
			} else {
				String newValue = String.format("%.0f", Math.pow(2, rank));
							
				this.tile.setText(newValue);
				this.tile.setBackground(
					new Background(new BackgroundFill(COLOR[rank], new CornerRadii(5), Insets.EMPTY))
				);
			}
		}

	@Override
	public void playWinTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playLostTile() {
		ScaleTransition scaleTransition = new ScaleTransition();
		scaleTransition.setDuration(new Duration(50.0));
		scaleTransition.setNode(tile);
		scaleTransition.setToX(0);
		scaleTransition.setToY(0);
		scaleTransition.setCycleCount(1);		
		scaleTransition.play();	
	}
		


}
