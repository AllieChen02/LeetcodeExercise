package Graph.P310MinimumHeightTrees;

import java.util.*;

/**
 * @CLassName MinimumHeightTrees
 * @Description TODO
 * @Author cst
 * @Date 1/27/21  2:21 PM
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // undirected graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++ ) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        // 从叶子节点开始，寻找无向图中最后一个度为0的节点
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                int curr = queue.poll();
                res.add(curr);
                for (int j = 0; j < graph.get(curr).size(); j++) {
                    indegree[graph.get(curr).get(j)]--;
                    if (indegree[graph.get(curr).get(j)] == 1) {
                        queue.offer(graph.get(curr).get(j));
                    }
                }
            }
        }
        return res;
    }
}
