package Graph.P1267CountServersThatCommunicate;

/**
 * @CLassName CountServersThatCommunicate
 * @Description TODO
 * @Author cst
 * @Date 1/30/21  3:19 PM
 */
public class CountServersThatCommunicate {
    private static CountServersThatCommunicate ONLY = null;
    public static CountServersThatCommunicate getInstance() {
        if (ONLY == null) {
            ONLY = new CountServersThatCommunicate();
        }
        return ONLY;
    }
    public int countServers(int[][] grid) {
        int res = 0;
        if (grid == null || grid[0].length == 0) {
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 记录每一行/每一列拥有server的数量
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    res++;
                }
            }
        }

        // delete those who only has one server in the row/ column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (row[i] == 1 && col[j] == 1){
                        res--;
                    }
                }
            }
        }
        return res;
    }
}
