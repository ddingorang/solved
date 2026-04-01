import heapq
from collections import defaultdict

n, m, r = map(int, input().split(' '))
items = list(map(int, input().split(' ')))
g = defaultdict(list)
result = []

for _ in range(r) :
    s, e, l = map(int, input().split(' '))
    g[s].append((e, l))
    g[e].append((s, l))

for i in range(1, n+1) :
    dist = {node : float('inf') for node in g}
    dist[i] = 0 # 출발 노드는 거리가 0
    queue = []
    heapq.heappush(queue, [dist[i], i])

    while queue:
        curdist, curnode = heapq.heappop(queue)

        if dist[curnode] < curdist:
            continue

        for neighbor in g[curnode]:
            # neighbor => (도착노드, 길이)
            distance = curdist + neighbor[1]

            if distance < dist[neighbor[0]] :
                dist[neighbor[0]] = distance
                heapq.heappush(queue, [distance, neighbor[0]])

    temp = 0
    for i, e in dist.items():
        if e <= m: temp += items[i-1]
    result.append(temp)

print(max(result))
