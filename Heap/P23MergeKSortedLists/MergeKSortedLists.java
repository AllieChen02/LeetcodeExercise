package Heap.P23MergeKSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @CLassName MergeKSortedLists
 * @Description TODO
 * @Author cst
 * @Date 1/19/21  1:57 PM
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            pq.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            root.next = temp;
            root = root.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
