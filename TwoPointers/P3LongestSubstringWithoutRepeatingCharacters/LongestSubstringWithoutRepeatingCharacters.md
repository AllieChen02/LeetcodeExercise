# P3 Longest Substring Without Repeating Characters
## Sliding window
    - Scan the string by two pointer. One(j) is to traverse the whole string, the other(i) is to store the start index of the substring from i to j-1. and use a hashmap/hashset to record whether this character value has been visited. if it does, we just need to move i.
    - Space complexity: O(N). We need N space for the sliding window

## Time complexity
    In the worst case, we have to visit each character twice by i and j
## Space complexity
    Space complexity: O(N). We need N space for the sliding window