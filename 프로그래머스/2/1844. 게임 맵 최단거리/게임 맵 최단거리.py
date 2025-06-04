from collections import deque

def solution(maps):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    q = deque()
    q.append((0, 0, 1))  # x, y, 거리

    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    visited[0][0] = True  # 시작 지점 방문 체크

    while q:
        curx, cury, curd = q.popleft()

        if curx == len(maps[0]) - 1 and cury == len(maps) - 1:
            return curd  # 최단 거리 반환

        for i in range(4):  # 모든 방향 탐색
            nx = curx + dx[i]
            ny = cury + dy[i]

            if 0 <= nx < len(maps[0]) and 0 <= ny < len(maps):
                if maps[ny][nx] == 1 and not visited[ny][nx]:
                    q.append((nx, ny, curd + 1))
                    visited[ny][nx] = True

    return -1  # 도달 불가
