from collections import deque
import sys

# 빠른 입력을 위해 사용 (백준 필수)
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)] # 입력 조건 확인 (n, m 순서)
dist = [[-1] * m for _ in range(n)] # -1로 초기화

q = deque()

for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            q.append((i, j))
            dist[i][j] = 0
        elif board[i][j] == 0:
            dist[i][j] = 0 # 갈 수 없는 곳은 0

# BFS 시작 (딱 한 번만 수행)
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

while q:
    curi, curj = q.popleft()
    for d in range(4):
        ni, nj = curi + dx[d], curj + dy[d]
        if 0 <= ni < n and 0 <= nj < m:
            # 아직 방문하지 않았고(-1), 갈 수 있는 땅(1)인 경우
            if dist[ni][nj] == -1 and board[ni][nj] == 1:
                dist[ni][nj] = dist[curi][curj] + 1
                q.append((ni, nj))

for i in range(n) :
    for j in range(m) :
        print(f'{dist[i][j]} ', end='')
    print()

