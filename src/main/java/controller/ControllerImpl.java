package controller;

import model.Tile;
import model.Board;
import model.Board.Direction;
import model.BoardImpl;
import view.View;
import view.ViewImpl;

public class ControllerImpl implements Controller {

	private int size;
	private int rank ;
	private Board board;
	private View view;
	boolean win,lose;
	public ControllerImpl(int size) {
		this.size = size;
		this.rank = 0;
		board = new BoardImpl(size);
		
	}

	@Override
	public void setModel(Board board) {
		this.board=board;
		
	}

	@Override
	public void setView(View view) {
		this.view=view;
	}

	
	private void move(Direction direction){
		board.packIntoDirection(direction);
        board.commit();
        drawBoard();
	}
	
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		move(Direction.TOP);
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		move(Direction.BOTTOM);
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		move(Direction.LEFT);
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		move(Direction.RIGHT);
	}
	public void drawBoard() {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				Tile tile = board.getTile(i, j);
				view.setTile(j, i,(tile != null) ? tile.getRank() : 0);
			}
		}
	}
}
