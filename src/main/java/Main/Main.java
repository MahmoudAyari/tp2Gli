package Main;
 
import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;
import model.BoardImpl; 
import view.View;
import view.ViewImpl; 
 

public class Main extends Application {
 
	final int size = 4;
	final double windowSize = 500.0;
	
  
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2048");
       
        Board board = new BoardImpl(size);
        
        Controller controller = new ControllerImpl(size);
        View view = new ViewImpl(size,windowSize);
       
        controller.setView(view);
        controller.setModel(board);
        view.setController(controller);
        board.setController(controller);
        board.startGame();
        controller.drawBoard();
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