package Graph.P210CourseScheduleII;

import junit.framework.TestCase;

/**
 * @CLassName CourseScheduleIITest
 * @Description TODO
 * @Author cst
 * @Date 2/1/21  2:48 PM
 */
public class CourseScheduleIITest extends TestCase {
    public void testFindOrder() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] res = new CourseScheduleII().findOrder(numCourses, prerequisites);
        assertEquals(0, res[0]);
        assertEquals(1, res[1]);
    }
}
