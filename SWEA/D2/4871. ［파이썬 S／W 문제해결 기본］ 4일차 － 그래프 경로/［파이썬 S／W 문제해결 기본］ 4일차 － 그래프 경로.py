from collections import defaultdict, deque

T = int(input())
result = []

for test_case in range(1, T + 1):
    v, e = map(int, input().split())
    g = defaultdict(list)
    visited = [0 for _ in range(v + 1)]

    for _ in range(e):
        s, f = map(int, input().split())
        g[s].append(f)

    start, finish = map(int, input().split())
    q = deque()
    q.append(start)
    visited[start] = 1

    while q:
        cur = q.popleft()
        for node in g[cur]:
            if not visited[node]:
                visited[node] = 1
                q.append(node)

    # finish 노드가 방문되었는지만 확인하면 경로가 존재하는지 알 수 있음
    result.append(1 if visited[finish] else 0)

for index, r in enumerate(result):
    print(f'#{index + 1} {r}')
