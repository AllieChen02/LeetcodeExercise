package Graph.P210CourseScheduleII;

import java.util.*;

/**
 * @CLassName CourseScheduleII
 * @Description TODO
 * @Author cst
 * @Date 2/1/21  2:26 PM
 */
public class CourseScheduleII {
    // topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i<numCourses; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i<size; i++) {
                int curr = queue.poll();
                if (visited.add(curr)) {
                    list.add(curr);
                    for (int next : graph.get(curr)) {
                        inDegree[next] -= 1;
                        if (inDegree[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i =0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res.length == numCourses ? res : new int[]{};
    }
}
