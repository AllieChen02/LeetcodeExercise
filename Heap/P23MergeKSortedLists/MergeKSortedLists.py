import unittest
from typing import List
import heapq

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__ = lambda self, other: self.val < other.val
        h, dummy = [], ListNode(0)
        root = dummy
        for i in lists:
            if i: heapq.heappush(h, i)
        
        while h:
            temp = heapq.heappop(h)
            root.next = temp
            root = root.next
            if temp.next:
                heapq.heappush(h, temp.next)
        return dummy.next