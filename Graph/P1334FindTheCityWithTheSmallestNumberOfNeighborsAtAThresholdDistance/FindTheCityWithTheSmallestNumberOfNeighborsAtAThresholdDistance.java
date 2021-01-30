package Graph.P1334FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

import java.util.*;

/**
 * @CLassName FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance
 * @Description TODO
 * @Author cst
 * @Date 1/27/21  12:59 PM
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // construct the graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        int min = n + 1;
        int res = -1;
        // traverse all city
        for (int i = 0; i < n; i++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            queue.offer(new int[]{i, distanceThreshold});
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            while (!queue.isEmpty()) {
                int[] city = queue.poll();
                if (visited.add(city[0])) {
                    count++;
                    Map<Integer, Integer> nexts = graph.get(city[0]);
                    for (int next : nexts.keySet()) {
                        // still have distance threshold
                        if (city[1] >= nexts.get(next)) {
                            queue.offer(new int[]{next, city[1] - nexts.get(next)});
                        }
                    }
                }
            }
            if (count - 1 <= min) {
                min = count - 1;
                res = i;
            }
        }
        return res;
    }
}
