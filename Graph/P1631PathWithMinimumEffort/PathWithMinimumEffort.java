package Graph.P1631PathWithMinimumEffort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @CLassName PathWithMinimumEffort
 * @Description TODO
 * @Author cst
 * @Date 2/5/21  1:29 PM
 */
public class PathWithMinimumEffort {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dict = new int[m][n]; // 用来记录走到目前这个位置，整条path里需要到cost最大值
        for(int[] effort: dict){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        // Dijikstra
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[]{0, 0, 0}); // cost, locX, locY
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int locX = curr[1];
            int locY = curr[2];
            if (locX == m - 1 && locY == n - 1) {
                return cost;
            }
            for (int[] dir : dirs) {
                int x = dir[0] + locX;
                int y = dir[1] + locY;
                if (x >=0 && y >= 0 && x < m && y < n) {
                    int newCost = Math.max(cost, Math.abs(heights[x][y] - heights[locX][locY]));
                    if (dict[x][y] > newCost) {
                        dict[x][y] = newCost;
                        pq.offer(new int[]{newCost, x, y});
                    }
                }
            }
        }
        return 0;
    }
}
