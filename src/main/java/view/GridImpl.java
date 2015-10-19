package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class GridImpl implements Grid{

	private GridPane gridPane;
	private Tile[][] board;
	public GridImpl(int size,double windowSize) {
		
		this.gridPane = new GridPane();
		this.gridPane.setHgap(size);
		this.gridPane.setVgap(size);
		
		board = new Tile[size-1][size-1];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				board[i][j] = new TileImpl(size, windowSize);
				gridPane.add(board[i][j].getTile(), i - 1, j - 1);
				gridPane.setAlignment(Pos.CENTER);
			}
		}
	}
	public GridPane getGridPane() {
		return gridPane;
	}
	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}
	
	
}
