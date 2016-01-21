package view;


import controller.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ViewImpl implements View{

	private BorderPane panel;
	private Grid grid;
	private double windowSize;
	private int size;
	private Controller controller;
	private BooleanProperty win;
	private BooleanProperty lost;
	
	public ViewImpl( int size,double windowSize) {
		super();
		this.windowSize = windowSize;
		panel = new BorderPane();
		setSize(size);
		win = new SimpleBooleanProperty();
		lost = new SimpleBooleanProperty();
		panel.setTop(top());
		panel.setBottom(footer());
	}

	@Override
	public void setSize(int size) {
		this.size=size;
		grid = new GridImpl(size, windowSize);
		panel.setCenter(grid.getGrid());
	}

	@Override
	public void setController(Controller controller) {
		this.controller=controller;
		grid.move(controller);
	}

	@Override
	public Parent getPanel() { 
		return panel;
	}

	@Override
	public void setTile(int x, int y, int rank) {
		grid.setTile(x, y, rank);
	}

	@Override
	public void setGamerWon(boolean win) {
		this.win.set(win);
	 }

	@Override
	public void setGamerLost(boolean lost) {
		this.lost.set(lost);
		
	}

	@Override
	public GUITile getTile(int x, int y) {
		return grid.getTile(x, y);
		
	}
	
	private Node top() {
		
		HBox info = new HBox(5);		
		 
		Button buttonNewGame = new Button("New game");

		info.setMinWidth(windowSize);
		 
        buttonNewGame.setFocusTraversable(false);
        
        buttonNewGame.setOnMouseClicked(e -> controller.initGame());

        info.getChildren().addAll(buttonNewGame);
        
        return info;
	}
	
	
	private Node footer() {
		HBox info = new HBox();
		
		final Label labelWin = new Label("You Win");
		
		final Label labelLost = new Label("Game Over");

		info.setMinWidth(windowSize);
		info.setAlignment(Pos.CENTER);
		
		labelWin.setStyle("-fx-font-family: Helvetica ;-fx-font-size: 16px;-fx-font-weight: bold;-fx-text-fill: green");		
		labelLost.setStyle("-fx-font-family: Helvetica ;-fx-font-size: 16px;-fx-font-weight: bold;-fx-text-fill: red");

		this.win.addListener((observable, oldValue, newValue) -> labelWin.setVisible(newValue));
		this.lost.addListener((observable, oldValue, newValue) -> labelLost.setVisible(newValue));
		
		labelWin.setVisible(false);
		labelLost.setVisible(false);
		
		info.getChildren().addAll(labelWin, labelLost);
		
		return info;
	}
	
	
	
}
