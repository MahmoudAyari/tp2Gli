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
@SuppressWarnings("restriction")
public class TileImpl  implements Tile {

	private final static Color[] COLOR = { Color.WHITE, Color.MINTCREAM, Color.MEDIUMSPRINGGREEN, Color.CYAN,
			Color.ROYALBLUE, Color.MIDNIGHTBLUE, Color.DARKCYAN, Color.BLUE, Color.DEEPSKYBLUE, Color.STEELBLUE,
			Color.LIGHTSKYBLUE, Color.GOLD, };
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
		


}
