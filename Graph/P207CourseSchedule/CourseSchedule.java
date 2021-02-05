package Graph.P207CourseSchedule;

import java.util.*;

/**
 * @CLassName CourseSchedule
 * @Description TODO
 * @Author cst
 * @Date 2/1/21  1:33 PM
 */
public class CourseSchedule {
    // build graph, and check if the graph has circle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] requisite : prerequisites) {
            graph.get(requisite[1]).add(requisite[0]);
            inDegree[requisite[0]]++;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                count++;
                if (visited.add(curr)) {
                    for (int next : graph.get(curr)) {
                        inDegree[next] -= 1;
                        if (inDegree[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return count == numCourses;
    }
}
