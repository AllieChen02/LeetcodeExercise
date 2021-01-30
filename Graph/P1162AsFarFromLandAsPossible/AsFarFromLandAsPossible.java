package Graph.P1162AsFarFromLandAsPossible;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @CLassName AsFarFromLandAsPossible
 * @Description Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 * find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
 * If no land or water exists in the grid, return -1.
 * <p>
 * The distance used in this problem is the Manhattan distance:
 * the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * @Author cst
 * @Date 1/29/21  11:56 AM
 */
public class AsFarFromLandAsPossible {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }
        // BFS, start from land, and explore the next water it will reach in this step.
        // At each level of bfs, we do distance++
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // if matrix has no water then ans = -1 so return -1
        if (queue.size() == grid.length * grid[0].length)
            return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            res++;
        }
        return res - 1;

    }
}
