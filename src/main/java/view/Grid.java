package view;

import controller.Controller;
import javafx.scene.Node;

public interface Grid {

	public void move(Controller controller);

	public Node getGrid();

	public GUITile getTile(int x, int y);

	public void setTile(int x, int y, int rank);
}
