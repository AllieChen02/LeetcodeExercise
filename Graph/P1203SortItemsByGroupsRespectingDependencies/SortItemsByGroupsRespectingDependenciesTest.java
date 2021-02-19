package Graph.P1203SortItemsByGroupsRespectingDependencies;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @CLassName SortItemsByGroupsRespectingDependenciesTest
 * @Description TODO
 * @Author cst
 * @Date 2/13/21  3:55 PM
 */
public class SortItemsByGroupsRespectingDependenciesTest extends TestCase {
    public void testSortItems() {
        int n = 8;
        int m = 2;
        int[] group = new int[]{-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Collections.emptyList());
        beforeItems.add(Collections.singletonList(6));
        beforeItems.add(Collections.singletonList(5));
        beforeItems.add(Collections.singletonList(6));
        beforeItems.add(Arrays.asList(3,6));
        beforeItems.add(Collections.emptyList());
        beforeItems.add(Collections.emptyList());
        beforeItems.add(Collections.emptyList());
        int[] res = new SortItemsByGroupsRespectingDependencies().sortItems(n, m, group, beforeItems);
        System.out.println(res.length);
        assertEquals(6, res[0]);
        assertEquals(3, res[1]);
        assertEquals(4, res[2]);
        assertEquals(5, res[3]);
        assertEquals(2, res[4]);
        assertEquals(0, res[5]);
        assertEquals(7, res[6]);
        assertEquals(1, res[7]);
    }
}
