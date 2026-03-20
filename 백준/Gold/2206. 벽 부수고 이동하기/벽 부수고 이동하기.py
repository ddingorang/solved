import sys
from collections import deque

# 빠른 입력을 위한 설정
input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

n, m = map(int, input().split())
field = [input().strip() for _ in range(n)]  # 문자열 리스트로 저장

# v[x][y][0]: 벽 안 부수고 방문, v[x][y][1]: 벽 부수고 방문
v = [[[False] * 2 for _ in range(m)] for _ in range(n)]


def bfs():
    q = deque([(0, 0, 0, 1)])  # x, y, through(0 or 1), depth
    v[0][0][0] = True

    while q:
        curx, cury, through, depth = q.popleft()

        # 도착 지점 도달 시 즉시 종료 (BFS의 특징: 처음 도달이 최단거리)
        if curx == n - 1 and cury == m - 1:
            return depth

        for i in range(4):
            nx, ny = curx + dx[i], cury + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                # 1. 이동할 곳이 빈 칸('0')인 경우
                if field[nx][ny] == '0' and not v[nx][ny][through]:
                    v[nx][ny][through] = True
                    q.append((nx, ny, through, depth + 1))

                # 2. 이동할 곳이 벽('1')이고, 아직 벽을 부순 적이 없는 경우
                elif field[nx][ny] == '1' and through == 0:
                    if not v[nx][ny][1]:
                        v[nx][ny][1] = True
                        # 주의: 여기서 through 자체를 1로 바꾸면 안 되고, 1을 전달만 해야 함!
                        q.append((nx, ny, 1, depth + 1))

    return -1  # 도달할 수 없는 경우


print(bfs())