package TwoPointers.P61RotateList;

import junit.framework.TestCase;

/**
 * @CLassName RotateListTest
 * @Description TODO
 * @Author cst
 * @Date 12/20/20  12:19 PM
 */
public class RotateListTest extends TestCase {
    public void testRotateRight() {
        int k = 2;
        ListNode dummy, r1, r2, r3, r4, r5;
        dummy = new ListNode(0);
        r1 = new ListNode(1);
        r2 = new ListNode(2);
        r3 = new ListNode(3);
        r4 = new ListNode(4);
        r5 = new ListNode(5);
        dummy.next = r1;
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = null;

        ListNode ans = new RotateList().rotateRight(dummy.next, k);
        int[] arr = new int[]{4,5,1,2,3};
        int idx = 0;
        while (ans != null) {
            assertEquals(arr[idx], ans.val);
            idx++;
            ans = ans.next;
        }
    }
}
