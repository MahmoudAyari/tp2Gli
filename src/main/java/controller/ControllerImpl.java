package controller;

import model.Tile;
import model.Board;
import model.Board.Direction;
import model.BoardImpl;
import view.View;
import view.ViewImpl;

public class ControllerImpl implements Controller {

	private int size;
	
	private Board board;
	private View view;
	boolean win,lose;
	public ControllerImpl(int size) {
		this.size = size;
		board = new BoardImpl(size);
		
	}
    /*
     * init new game
     */
	public void initGame() {
		
		board.setSideSizeInSquares(size);
		view.setSize(size);
		view.setController(this);
		board.startGame();
		
		drawBoard();
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
				view.setTile(j, i, (tile != null) ? tile.getRank() : 0);
			}
		}
	}
	
	
	
	private boolean ableToMove(Direction direction) {
        int offsetX = 0, offsetY = 0;
        int lowerX = 1, lowerY = 1;
        int upperX = size, upperY = size;
        
        switch (direction) {
            case LEFT:
                offsetX = - 1;
                lowerX = 2;
                break;
            case RIGHT:
                offsetX = + 1;
                upperX = size - 1;
                break;
            case BOTTOM:
                offsetY = + 1;
                upperY = size - 1;
                break;
            case TOP:
                offsetY = - 1;
                lowerY = 2;
        }
        
        for (int i = lowerY; i <= upperY; i++) {
            for (int j = lowerX; j <= upperX; j++) {
                if (board.getTile(i, j) != null) {
                    if (board.getTile(i + offsetY, j + offsetX) == null || board.getTile(i, j).getRank() == board.getTile(i + offsetY, j + offsetX).getRank()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
	
	@Override
	public boolean win() {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (board.getTile(i, j) != null && board.getTile(i, j).getRank() == 11) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean lost() {
		boolean lost =!(ableToMove(Direction.TOP)
        		||ableToMove(Direction.BOTTOM)
        		||ableToMove(Direction.LEFT)
        		||ableToMove(Direction.RIGHT));
		return lost;
	}
}
