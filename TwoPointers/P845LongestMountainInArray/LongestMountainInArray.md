# 845. Longest Mountain in Array
## Method 1: brute force (time limit exceeded)

    Traverse the given array and for each element, use two pointers, left and right to expand range. For worst case, Time complexity would be O(N^2)

## Method 2: One forward pass and one backward pass
    - We create an ascending array to count up hill length for each index. Same for descding array
    - Finally just a pass to find max(des[i] + asc[i] + 1), where des[i] and asc[i] must be positive, not zero

    e.g 0, 1, 2, 3, 4, 5, 6
    The result would be 7 if we do not limit des[i] and asc[i] should both be positive integers. 

    - Time complexity is O(N) since we only traverse array in linear time

    - Space complexity is O(N) since we use two array to count up hill length. 