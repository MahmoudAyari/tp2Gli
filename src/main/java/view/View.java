package view;

import controller.Controller;
import javafx.scene.Parent;
public interface View {

	
   public void setSize(int size);
   
   
   public void setController(Controller controller);
   
   
   public Parent getPanel();
}
