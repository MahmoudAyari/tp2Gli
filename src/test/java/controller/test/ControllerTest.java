package controller.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.BoardImpl;

public class ControllerTest {
	private final int SIZE = 3;
	
	private Controller controller;
	
	private BoardImpl board;
	
	@Before
	public void setUp() {
        board = new BoardImpl(SIZE);
		controller = new ControllerImpl(SIZE);
		controller.setModel(board);
	}

	@Test
	public void testWin() {
        board.loadBoard(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        Assert.assertFalse(controller.win());

        board.loadBoard(new int[][]{{11, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        Assert.assertTrue(controller.win());

        board.loadBoard(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 11}});
        Assert.assertTrue(controller.win());

        board.loadBoard(new int[][]{{0, 0, 0}, {0, 11, 0}, {0, 0, 0}});
        Assert.assertTrue(controller.win());
	}
	
	@Test
	public void testLost() {
        board.loadBoard(new int[][]{{1, 2, 2}, {4, 5, 6}, {7, 8, 9}});
        Assert.assertFalse(controller.lost());

        board.loadBoard(new int[][]{{1, 2, 3}, {4, 5, 5}, {7, 8, 9}});
        Assert.assertFalse(controller.lost());

        board.loadBoard(new int[][]{{1, 2, 3}, {4, 2, 5}, {7, 8, 9}});
        Assert.assertFalse(controller.lost());

        board.loadBoard(new int[][]{{1, 2, 3}, {4, 5, 9}, {7, 8, 9}});
        Assert.assertFalse(controller.lost());

        board.loadBoard(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 7, 9}});
        Assert.assertFalse(controller.lost());
        
        board.loadBoard(new int[][]{{1, 2, 1}, {4, 5, 6}, {1, 8, 9}});
        Assert.assertTrue(controller.lost());

        board.loadBoard(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Assert.assertTrue(controller.lost());
	}
}
