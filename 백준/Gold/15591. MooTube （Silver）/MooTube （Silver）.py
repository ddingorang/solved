from collections import defaultdict, deque

n, qs = tuple(map(int, input('').split(' ')))
graph = defaultdict(list)
result = []

for _ in range(n-1):
    p, q, r = tuple(map(int, input('').split(' ')))
    graph[p].append((q, r))
    graph[q].append((p, r))

for _ in range(qs):
    dq = deque()
    visited = [0 for _ in range(n+1)]
    k, v = tuple(map(int, input('').split(' ')))
    cnt = 0
    dq.append(v)
    while dq:
        cur = dq.popleft()
        visited[cur] = 1
        for g in graph[cur]:
            if not visited[g[0]] :
                if g[1] >= k:
                    dq.append(g[0])
                    cnt += 1
    result.append(cnt)

for e in result:
    print(e)
