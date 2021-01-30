package BfsAndDfs.P1376TimeNeededToInformAllEmployees;

import junit.framework.TestCase;

/**
 * @CLassName TimeNeededToInformAllEmployeesTest
 * @Description TODO
 * @Author cst
 * @Date 1/26/21  10:54 AM
 */
public class TimeNeededToInformAllEmployeesTest extends TestCase {
    public void testNumOfMinutes() {
        int n = 7, headID = 6;
        int[] manager = new int[]{1, 2, 3, 4, 5, 6, -1};
        int[] informTime = new int[]{0, 6, 5, 4, 3, 2, 1};
        assertEquals(21, new TimeNeededToInformAllEmployees().numOfMinutes(n, headID, manager, informTime));
        assertEquals(21, new TimeNeededToInformAllEmployees().numOfMinutes_BFS(n, headID, manager, informTime));

        n = 8;
        headID = 0;
        manager = new int[]{-1, 5, 0, 6, 7, 0, 0, 0};
        informTime = new int[]{89, 0, 0, 0, 0, 523, 241, 519};
        assertEquals(612, new TimeNeededToInformAllEmployees().numOfMinutes(n, headID, manager, informTime));
        assertEquals(612, new TimeNeededToInformAllEmployees().numOfMinutes_BFS(n, headID, manager, informTime));
    }
}
