package view;

import javafx.scene.Node;

public interface GUITile {

	
	public int getRank();
	
	public void setRank(int rank);
	
	public Node getTile();
	
	public void playWinTile();

	public void playLostTile();
}
