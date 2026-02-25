
INF = int(1e9)
n, m = map(int, input().split(" "))
edges = [[INF] * (n+1) for _ in range(n+1)]
result = []

for i in range(m) :
    a, b = tuple(map(int, input().split(' ')))
    edges[a][b] = 1
    edges[b][a] = 1

for k in range(1, n + 1):
    # a = 출발 노드
    for a in range(1, n + 1):
        # b = 도착 노드
        for b in range(1, n + 1):
            edges[a][b] = min(edges[a][b], edges[a][k] + edges[k][b])

for i in range(1, n+1) :
    temp = 0
    for j in range(1, n+1):
        if i != j and edges[i][j] < INF: temp += edges[i][j]
    result.append(temp)


minvalue = min(result)
for idx, e in enumerate(result):
    if(e == minvalue) :
        print(idx+1)
        break