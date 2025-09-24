import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input())
d = defaultdict(list)

for _ in range(e):
    u, v_, w = map(int, input().split())
    d[u].append((v_, w))

distance = [float('inf')] * (v + 1)
distance[k] = 0

pq = []
heapq.heappush(pq, (0, k))

while pq:
    dist, now = heapq.heappop(pq)
    if distance[now] < dist:
        continue

    for nextnode, cost in d[now]:
        newdist = cost + dist
        if newdist < distance[nextnode]:
            distance[nextnode] = newdist
            heapq.heappush(pq, (newdist, nextnode))

for i in range(1, v + 1):
    if distance[i] == float('inf'):
        print("INF")
    else:
        print(distance[i])
