package controller;

import model.Board;
import view.View;

public interface Controller {

	public void setModel(Board board);

	public void setView(View view);

	public void moveUp();

	public void moveDown();

	public void moveLeft();

	public void moveRight();

	public void drawBoard();
	
	public boolean win();

	public boolean lost();
}
