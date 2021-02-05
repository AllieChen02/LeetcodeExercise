package Graph.P841KeysAndRooms;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @CLassName KeysAndRoomsTest
 * @Description TODO
 * @Author cst
 * @Date 1/31/21  12:42 PM
 */
public class KeysAndRoomsTest extends TestCase {
    public void testCanVisitAllRooms() {
        List<Integer> temp1 = Arrays.asList(1,3);
        List<Integer> temp2 = Arrays.asList(3,0,1);
        List<Integer> temp3 = Arrays.asList(2);
        List<Integer> temp4 = Arrays.asList(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(temp1);
        rooms.add(temp2);
        rooms.add(temp3);
        rooms.add(temp4);
        assertFalse(new KeysAndRooms().canVisitAllRooms(rooms));
    }
}
