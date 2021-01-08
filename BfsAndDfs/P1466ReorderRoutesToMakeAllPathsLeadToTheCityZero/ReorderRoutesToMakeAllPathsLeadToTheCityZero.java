package BfsAndDfs.P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero;

import java.util.*;

/**
 * @CLassName ReorderRoutesToMakeAllPathsLeadToTheCityZero
 * @Description TODO
 * @Author cst
 * @Date 1/6/21  3:06 PM
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        // construct a graph
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] arr : connections) {
            if (!map.containsKey(arr[0])) {
                map.put(arr[0], new ArrayList<>());
            }
            map.get(arr[0]).add(new int[]{arr[1], 1});

            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(new int[]{arr[0], 0});
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<int[]> neighbours = map.get(curr);
            for (int[] arr : neighbours) {
                if (!set.contains(arr[0])) {
                    res += arr[1];
                    queue.offer(arr[0]);
                    set.add(arr[0]);
                }
            }
        }
        return res;
    }
}
