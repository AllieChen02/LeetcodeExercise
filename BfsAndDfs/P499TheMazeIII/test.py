import heapq

h = []
heapq.heappush(h, (1, "bh"))
heapq.heappush(h, (1, "abh"))
print(heapq.heappop(h))