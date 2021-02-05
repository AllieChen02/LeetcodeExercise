package Graph.P841KeysAndRooms;

import java.util.*;

/**
 * @CLassName KeysAndRooms
 * @Description TODO
 * @Author cst
 * @Date 1/31/21  12:27 PM
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // construct a graph， 判断是否只有一个component (dfs，看有什么数字没走)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int m = rooms.size();
        for (int i = 0; i < m; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                graph.get(i).add(rooms.get(i).get(j));
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (visited.add(curr)) {
                    for (int next : graph.get(curr)) {
                        queue.offer(next);
                    }

                }
            }
        }
        return visited.size() == m;
    }
}
