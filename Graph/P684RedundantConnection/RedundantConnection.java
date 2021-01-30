package Graph.P684RedundantConnection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName RedundantConnection
 * @Description TODO
 * @Author cst
 * @Date 1/26/21  1:23 PM
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // index is start, value is the final destination
        int[] sets = new int[n + 1];
        for (int[] edge : edges) {
            int u = find(sets, edge[0]);
            int v = find(sets, edge[1]);
            // they are in a circle
            if (u == v) {
                return edge;
            }
            sets[u] = v;
        }
        return null;
    }

    public int find(int[] sets, int v) {
        return sets[v] == 0 ? v : find(sets, sets[v]);
    }
}
