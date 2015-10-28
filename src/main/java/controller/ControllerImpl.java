package controller;

import model.Board;
import model.Board.Direction;
import view.View;

public class ControllerImpl implements Controller {

	private int size;
	private Board broad;
	private View view;
	
	public ControllerImpl(int size) {
		this.size = size;
	}

	@Override
	public void setModel(Board board) {
		this.broad=board;
		
	}

	@Override
	public void setView(View view) {
		this.view=view;
	}

	
	private void move(Direction direction){
		
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

}
