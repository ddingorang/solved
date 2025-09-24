import sys
input = sys.stdin.readline

INF = int(1e9)

n = int(input())  # 정점 개수
m = int(input())  # 간선 개수

# 거리 배열 초기화
dist = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신은 0
for i in range(1, n + 1):
    dist[i][i] = 0

# 간선 입력
for _ in range(m):
    a, b, c = map(int, input().split())
    dist[a][b] = min(dist[a][b], c)  # 중복 간선 대비

# 플로이드-워셜
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

# 결과 출력
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if dist[i][j] == INF:
            print(0, end=" ")  # 갈 수 없는 경우 0
        else:
            print(dist[i][j], end=" ")
    print()
