# 881. Boats To Save People
## Greedy
    Since each boat carries at most 2 people at the same time, we should satisfy heaviest person firstl. If the heaviest person could share a boat with the lightest person, then do so. Otherwise, the heaviest person should take a boat on his own.  The reason is that we should make full use of the maximum weight of a boat to save total number of boats. 


 # Time Complexity
 O(NlogN), where N is the length of people list. The reason is that we need to sort the array and then traverse it. 

 # Space Complexity
 O(N). The three sorting algorithms, namely merge, heap and quick sort.
    
    - Merge Sort: it is usually used with linked list
    - Heap Sort: maintain a heap structure, and initial size should be at least N
    - Quick Sort: use a stack to maintain the recursion state, the total size should be at least N as well. 