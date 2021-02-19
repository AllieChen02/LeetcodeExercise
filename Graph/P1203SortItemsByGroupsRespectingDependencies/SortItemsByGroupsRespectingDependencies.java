package Graph.P1203SortItemsByGroupsRespectingDependencies;

import java.util.*;

/**
 * @CLassName SortItemsByGroupsRespectingDependencies
 * @Description TODO
 * @Author cst
 * @Date 2/13/21  3:19 PM
 */
public class SortItemsByGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> graphItems = new HashMap<>();
        int[] indegreeItems = new int[n];
        Map<Integer, List<Integer>> graphGroups = new HashMap<>();

        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m += 1;
            }
        }
        int[] indegreeGroups = new int[m];
        for (int i = 0; i < n; i++) {
            graphItems.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graphGroups.put(i, new ArrayList<>());
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j = 0; j < beforeItems.get(i).size(); j++) {
                int pre = beforeItems.get(i).get(j);
                graphItems.get(pre).add(i);
                indegreeItems[i]++;
                if (group[i] != group[pre]) {
                    graphGroups.get(group[pre]).add(group[i]);
                    indegreeGroups[group[i]]++;
                }
            }
        }
        List<Integer> itemSort = topologicalSort(graphItems, indegreeItems);
        List<Integer> groupSort = topologicalSort(graphGroups, indegreeGroups);

        List<Integer> arrSort = new ArrayList<>();
        // find order of items within each group
        Map<Integer, List<Integer>> orderInGroup = new HashMap<>();
        for (int j = 0; j < m; j++) {
            orderInGroup.put(j, new ArrayList<>());
        }
        for (int item : itemSort) {
            orderInGroup.get(group[item]).add(item);
        }

        for (int g : groupSort) {
            arrSort.addAll(orderInGroup.get(g));
        }
        int[] res = new int[arrSort.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrSort.get(i);
        }
        return res;
    }

    public List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int key : graph.keySet()) {
            if (inDegree[key] == 0) {
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                res.add(temp);
                if (graph.get(temp) != null) {
                    for (int next : graph.get(temp)) {
                        inDegree[next] -= 1;
                        if (inDegree[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return res.size() == graph.size() ? res : new ArrayList<>();
    }
}
