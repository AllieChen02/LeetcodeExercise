package BfsAndDfs.P1376TimeNeededToInformAllEmployees;

import java.util.*;

/**
 * @CLassName TimeNeededToInformAllEmployees
 * @Description TODO
 * @Author cst
 * @Date 1/26/21  10:25 AM
 */
public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++ ){
            if (!graph.containsKey(manager[i])) {
                graph.put(manager[i], new ArrayList<>());
            }
            graph.get(manager[i]).add(i);
        }
        return dfs(graph,headID, informTime);
    }

    // 构建完有向图后，下面可以dfs， 然后max来记录每条path里面的最大值
    public int dfs(Map<Integer, List<Integer>> graph, int curr, int[] informTime) {
        int max = 0;
        if (!graph.containsKey(curr)) {
            return max;
        }
        for (int sub : graph.get(curr)) {
            max = Math.max(max, dfs(graph, sub, informTime));
        }
        return max + informTime[curr];
    }

    // BFS
    public int numOfMinutes_BFS(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++ ){
            if (!graph.containsKey(manager[i])) {
                graph.put(manager[i], new ArrayList<>());
            }
            graph.get(manager[i]).add(i);
        }
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, informTime[headID]});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            res = Math.max(res, curr[1]);
            if (!graph.containsKey(curr[0])) {
                continue;
            }
            for (int next : graph.get(curr[0])) {
                queue.offer(new int[]{next, curr[1] + informTime[next]});
            }
        }
        return res;
    }
}
