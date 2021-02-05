package Graph.P207CourseSchedule;

import junit.framework.TestCase;

/**
 * @CLassName CourseScheduleTest
 * @Description TODO
 * @Author cst
 * @Date 2/1/21  2:22 PM
 */
public class CourseScheduleTest extends TestCase {
    public void testCanFinish() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}, {0,1}};
        assertFalse(new CourseSchedule().canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{1,0}};
        assertTrue(new CourseSchedule().canFinish(numCourses, prerequisites));
    }
}
