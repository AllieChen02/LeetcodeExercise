package BfsAndDfs.P505TheMazeII;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @CLassName TheMazeII
 * @Description TODO
 * @Author cst
 * @Date 1/22/21  8:32 PM
 */
public class TheMazeII {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0} , {0, -1}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        //Queue<int[]> queue = new LinkedList<>();
        /**
         * Here we adopt PriorityQueue instead of normal queue
         * everytime we need the minimum path number
         * */
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                                (a, b) -> Integer.compare(a[2], b[2]));
        queue.add(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return curr[2];
            }
            visited[curr[0]][curr[1]] = true;
            for (int[] dir : dirs) {
                int nextX = curr[0];
                int nextY = curr[1];
                int path = curr[2];
                while (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY <                                   maze[0].length && maze[nextX][nextY] == 0) {
                    // keep moving
                    nextX += dir[0];
                    nextY += dir[1];
                    path += 1;
                }

                // 退回上一格
                nextX -= dir[0];
                nextY -= dir[1];
                path -= 1;
                if (visited[nextX][nextY]) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY, path});
            }
        }
        return -1;


    }
}
