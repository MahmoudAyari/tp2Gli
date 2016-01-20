package view;

import controller.Controller; 
import javafx.scene.Parent;
public interface View {
 
   public void setSize(int size);
    
   public void setController(Controller controller);
    
   public Parent getPanel();
   
   public void setTile(int x,int y, int rank);
   
   public void setGamerWon(boolean win);
 
   public void setGamerLost(boolean lost);
   
   public GUITile getTile(int x, int y);
}
