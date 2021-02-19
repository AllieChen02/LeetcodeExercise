package BfsAndDfs.P499TheMazeIII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @CLassName TheMazeIII
 * @Description TODO
 * @Author cst
 * @Date 2/17/21  12:09 PM
 */
class Node {
    int cost;
    int x;
    int y;
    String c;
    Node(int cost, int x, int y, String c) {
        this.cost = cost;
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

public class TheMazeIII {
    private char[] direction = {'d', 'l', 'r', 'u'};
    private int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost != o2.cost ? o1.cost - o2.cost : o1.c.compareTo(o2.c);
            }
        });
        pq.offer(new Node(0, ball[0], ball[1], ""));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while(!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i<size; i++ ){
                Node curr = pq.poll();
                if (curr.x == hole[0] && curr.y == hole[1]) {
                    return curr.c;
                }
                if (visited[curr.x][curr.y]) {
                    continue;
                }
                visited[curr.x][curr.y] = true;
                for (int j = 0; j<dirs.length; j++) {
                    int newx = curr.x;
                    int newy = curr.y;
                    int newcost = curr.cost;
                    String ds = curr.c;

                    while (newx + dirs[j][0] >= 0 && newx + dirs[j][0] < maze.length
                            && newy + dirs[j][1] >= 0 && newy + dirs[j][1] < maze[0].length
                            && maze[newx + dirs[j][0]][newy + dirs[j][1]] == 0) {
                        newx += dirs[j][0];
                        newy += dirs[j][1];
                        newcost += 1;
                        if (newx == hole[0] && newy == hole[1]) {
                            break;
                        }
                    }
                    if (!visited[newx][newy]) {
                        pq.offer(new Node(newcost, newx, newy, ds+direction[j]));
                    }
                }
            }
        }
        return "impossible";
    }
}
