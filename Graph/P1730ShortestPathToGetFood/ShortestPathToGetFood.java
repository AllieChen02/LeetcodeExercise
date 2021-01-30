package Graph.P1730ShortestPathToGetFood;

import java.util.*;

/**
 * @CLassName ShortestPathToGetFood
 * @Description TODO
 * @Author cst
 * @Date 1/28/21  3:08 PM
 */
public class ShortestPathToGetFood {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j, 1});
                    break;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nextX = dir[0] + curr[0];
                int nextY = dir[1] + curr[1];
                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                        && grid[nextX][nextY] != 'X') {
                    if (grid[nextX][nextY] == '#') {
                        return curr[2];
                    } else if (grid[nextX][nextY] == 'O') {
                        grid[nextX][nextY] = 'X';
                        queue.offer(new int[]{nextX, nextY, curr[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
