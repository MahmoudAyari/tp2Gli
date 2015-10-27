package view;

import controller.Controller;
import javafx.scene.Node;

public interface Grid {

	public void setController(Controller controller);

	public Node getGrid();

	public Tile getTile(int x, int y);

	public void setTile(int x, int y, int rank);
}
