package BfsAndDfs.P323NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.*;

/**
 * @CLassName NumberOfConnectedComponentsInAnUndirectedGraph
 * @Description TODO
 * @Author cst
 * @Date 1/25/21  12:26 PM
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        if (edges == null || edges.length == 0) {
            return res;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        // dfs
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfs(graph, visited, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int curr) {
        for (int next : graph.get(curr)) {
            if (visited.add(next)) {
                dfs(graph, visited, next);
            }
        }
    }
}
