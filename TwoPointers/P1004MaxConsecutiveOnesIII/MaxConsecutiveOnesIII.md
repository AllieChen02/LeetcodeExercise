# P1004 Max Consecutive Ones III

## Sliding window(Two Pointers)
    Use two pointers, start and end to construct a subarray as a sliding window. Also introduce one parameter to count the total number of zeros in this sliding window. When it exceeds K, we have to move start pointer.
## Time complexity
    O(N). Each element in array would be visited at most twice, once by the end pointer and once by 
    the left pointer.
## Space complexity
    O(1). Only constant space required for start, end pointers, sum.