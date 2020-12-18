# P209 Minimum Size Subarray Sum
## Sliding window
    - Use two pointers to create a sliding window. One for the start and another for the end
      of the current subarray. Everytime moves the end pointer, we have to check whether the subarray
      is greater than target value. It it does, we could compare the length of current subarray 
      with the smaller value and then continue to moves start pointer so as to keep the sum greater than target
      as well as maintain the lowest size possbible
## Time complexity
    O(N). Each element in array would be visited at most twice, once by the end pointer and once by 
    the left pointer. 
## Space complexity
    O(1). Only constant space required for start, end pointers, sum. 