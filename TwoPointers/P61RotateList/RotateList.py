import unittest

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        fast = dummy
        slow = dummy
        len = 0
        while fast.next:
            len += 1
            fast = fast.next
        move = len - k % len
        while move > 0:
            slow = slow.next
            move -= 1
        
        fast.next = head # currently, dummy.next is 1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5
        dummy.next = slow.next
        slow.next = None
        return dummy.next
    
class UnitTest(unittest.TestCase):
    def test_1(self):
        k = 2
        dummy = ListNode(0) 
        r1 = ListNode(1) 
        r2 = ListNode(2) 
        r3 = ListNode(3) 
        r4 = ListNode(4) 
        r5 = ListNode(5) 
        dummy.next = r1
        r1.next = r2
        r2.next = r3
        r3.next = r4
        r4.next = r5
        r5.next = None 

        ans = Solution().rotateRight(dummy.next, k) 
        arr = [4,5,1,2,3] 
        idx = 0 
        while (ans != None):
            self.assertEqual(arr[idx], ans.val) 
            idx = idx + 1
            ans = ans.next 
if __name__ == "__main__":
    unittest.main() 