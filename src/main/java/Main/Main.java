package Main;


import javax.swing.border.Border;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;
import model.BoardImpl;
import view.GridImpl;
import view.View;
import view.ViewImpl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 

public class Main extends Application {
 
	final int size = 4;
	final double windowSize = 500.0;
	
  
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2048");
       
        Board board = new BoardImpl(size);
        board.addTile();
        Controller controller = new ControllerImpl(size);
        View view = new ViewImpl(size,windowSize);
        
        view.setController(controller);
        controller.setView(view);
        
        //Adding GridPane to the scene
        Scene scene = new Scene(view.getPanel(), windowSize, windowSize + 60);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
	 public static void main(String[] args) {
	        launch(args);
	    }
}