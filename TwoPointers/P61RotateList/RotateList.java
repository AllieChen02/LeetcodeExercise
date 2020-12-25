package TwoPointers.P61RotateList;

/**
 * @CLassName RotateList
 * @Description
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 * head = [1,2,3,4,5], k = 2
 * output = [4,5,1,2,3]
 *
 * @Author cst
 * @Date 12/20/20  12:19 PM
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode root = dummy;
        ListNode ptr = dummy;
        int len = 0;
        while(root.next != null) {
            root = root.next;
            len += 1;
        }
        int move = len - k % len;
        while (move > 0) {
            ptr = ptr.next;
            move--;
        }
        root.next = head; // currently, head becomes: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5
        dummy.next = ptr.next; // 4, 5, 1, 2, 3, 4, 5 (remove 1, 2,3)
        ptr.next = null; // 4,5,1,2,3
        return dummy.next;
    }
}
