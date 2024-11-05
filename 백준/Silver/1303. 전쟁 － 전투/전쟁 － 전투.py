import sys
from collections import deque

n, m = map(int, sys.stdin.readline().rstrip().split())  # n: 가로, m: 세로
field = [list(sys.stdin.readline().rstrip()) for _ in range(m)]  # 필드 입력

visited = [[False] * n for _ in range(m)]  # 방문 여부 체크
dx = [0, 1, 0, -1]  # 상, 우, 하, 좌
dy = [1, 0, -1, 0]

mypower = []  # 'W' 영역의 제곱 크기
enemypower = []  # 'B' 영역의 제곱 크기

# BFS로 각 영역을 탐색
for i in range(m):
    for j in range(n):
        if not visited[i][j]:  # 아직 방문하지 않은 칸이면 BFS 시작
            q = deque([(i, j)])  # 시작점을 큐에 넣기
            visited[i][j] = True
            soldiers = 0  # 연결된 영역의 크기
            curcolor = field[i][j]  # 현재 영역의 색

            while q:
                cury, curx = q.popleft()
                soldiers += 1  # 해당 칸을 하나의 연결된 영역으로 센다

                # 4방향으로 이동
                for k in range(4):
                    newy, newx = cury + dy[k], curx + dx[k]
                    if 0 <= newy < m and 0 <= newx < n:  # 필드 내에 있으면
                        if not visited[newy][newx] and field[newy][newx] == curcolor:
                            visited[newy][newx] = True
                            q.append((newy, newx))  # 연결된 칸을 큐에 추가

            # 해당 색상에 맞는 리스트에 제곱된 크기 추가
            if curcolor == 'W':
                mypower.append(soldiers ** 2)
            else:
                enemypower.append(soldiers ** 2)

# 출력: 'W'와 'B' 구역의 제곱 크기의 합
print(sum(mypower), sum(enemypower))
