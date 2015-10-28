package view;

import controller.Controller;
import javafx.scene.input.*;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;

public class GridImpl implements Grid {

	private GridPane gridPane;
	private Tile[][] board;

	public GridImpl(int size, double windowSize) {
		this.gridPane = new GridPane();
		this.gridPane.setHgap(size);
		this.gridPane.setVgap(size);

		board = new TileImpl[size + 1][size + 1];

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				board[i][j] = new TileImpl(size, windowSize);
				gridPane.add(board[i][j].getTile(), i - 1, j - 1);

			}

		}
	}

	@SuppressWarnings("restriction")
	@Override
	public void setController(Controller controller) {
		this.gridPane.addEventHandler(KeyEvent.KEY_RELEASED, (keyEvent)->{
	                          
	                            	switch (keyEvent.getCode()){
	                              case UP :controller.moveUp();break;
	                              case LEFT :controller.moveLeft();break;
	                              case RIGHT :controller.moveRight();break;
	                              case DOWN :controller.moveDown();break;
	                              default:break;
	                              }

	                                keyEvent.consume();
	                            }
	                    );
	 }

	@Override
	public Node getGrid() {
		return this.gridPane;
	}

	@Override
	public Tile getTile(int x, int y) {
		return board[x][y];
	}

	@Override
	public void setTile(int x, int y, int rank) {
		board[x][y].setRank(rank);
	}

}
