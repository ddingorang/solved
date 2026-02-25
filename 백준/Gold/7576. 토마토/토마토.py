from collections import deque
import sys

# 빠른 입력을 위해 사용 (백준 필수)
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)] # 입력 조건 확인 (n, m 순서)
v = [[False] * m for _ in range(n)] # -1로 초기화

q = deque()

for i in range(m):
    for j in range(n):
        if board[i][j] == 1:
            q.append((i, j))


# BFS 시작 (딱 한 번만 수행)
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

while q:
    curi, curj = q.popleft()

    for d in range(4):
        ni, nj = curi + dx[d], curj + dy[d]
        if 0 <= ni < m and 0 <= nj < n:
            # 아직 방문하지 않았고(-1), 갈 수 있는 땅(1)인 경우
            if board[ni][nj] == 0:
                board[ni][nj] = board[curi][curj] + 1
                q.append((ni,nj))

max_days = 0
for row in board:
    for tomato in row:
        if tomato == 0: # 끝까지 안 익은 게 있다면
            print(-1)
            exit()
    max_days = max(max_days, max(row))

print(max_days-1)