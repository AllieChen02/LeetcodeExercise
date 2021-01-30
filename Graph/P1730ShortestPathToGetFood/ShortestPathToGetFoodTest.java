package Graph.P1730ShortestPathToGetFood;

import junit.framework.TestCase;

/**
 * @CLassName ShortestPathToGetFoodTest
 * @Description TODO
 * @Author cst
 * @Date 1/28/21  3:22 PM
 */
public class ShortestPathToGetFoodTest extends TestCase {
    public void testGetFood() {
        char[][] grid = new char[][]{{'X', 'X', 'X', 'X', 'X', 'X'}, {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X'}};

        assertEquals(3, new ShortestPathToGetFood().getFood(grid));

        grid = new char[][]{{'X', '*'}, {'#', 'X'}};
        assertEquals(-1, new ShortestPathToGetFood().getFood(grid));

        grid = new char[][]{{'O', '*'}, {'#', 'O'}};
        assertEquals(2, new ShortestPathToGetFood().getFood(grid));
        
        grid = new char[][]{{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
        assertEquals(-1, new ShortestPathToGetFood().getFood(grid));
    }
}
