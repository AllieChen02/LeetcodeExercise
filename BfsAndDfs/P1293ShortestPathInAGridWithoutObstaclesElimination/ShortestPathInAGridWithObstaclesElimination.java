package BfsAndDfs.P1293ShortestPathInAGridWithoutObstaclesElimination;

import java.util.*;

public class ShortestPathInAGridWithObstaclesElimination {
    private int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int level = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1], tempK = curr[2];
                if(x == m - 1 && y == n - 1){
                    return level;
                }
                for(int[] dir : dirs){
                    int r = x + dir[0];
                    int c = y + dir[1];
                    int nextK = tempK;
                    if(r >= 0 && r < m && c >= 0 && c < n) {
                        if(grid[r][c] == 1) {
                            nextK++;
                        }
                        if(nextK <= k && !visited[r][c][nextK]) {
                            visited[r][c][nextK] = true;
                            queue.offer(new int[]{r, c, nextK});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
