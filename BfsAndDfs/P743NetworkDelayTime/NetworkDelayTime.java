package BfsAndDfs.P743NetworkDelayTime;

import java.util.*;

/**
 * @CLassName NetworkDelayTime
 * @Description TODO
 * @Author cst
 * @Date 1/24/21  3:17 PM
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = 0;
        if (times == null || times.length == 0) {
            return res;
        }
        // build a graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new HashMap<>());
            }
            graph.get(time[0]).put(time[1], time[2]);
        }
        Set<Integer> visited = new HashSet<>();
        // (a,b) a represents current node position, b represents current cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            // 到目前为止所花费到时间
            res = curr[1];
            n--;
            if (n == 0) {
                return res;
            }
            if (graph.containsKey(curr[0])) {
                for(int neighbor : graph.get(curr[0]).keySet()) {
                    pq.offer(new int[]{neighbor, curr[1] + graph.get(curr[0]).get(neighbor)});
                }
            }
        }
        return -1;
    }
}
