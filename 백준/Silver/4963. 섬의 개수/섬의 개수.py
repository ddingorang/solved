from collections import deque

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

results = []

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    field = [list(map(int, input().split())) for _ in range(h)]
    visited = [[0] * w for _ in range(h)]
    count = 0

    for i in range(h):
        for j in range(w):
            if field[i][j] == 1 and not visited[i][j]:
                q = deque([(i, j)])
                visited[i][j] = 1
                while q:
                    x, y = q.popleft()
                    for k in range(8):
                        nx, ny = x + dx[k], y + dy[k]
                        if 0 <= nx < h and 0 <= ny < w:
                            if field[nx][ny] == 1 and not visited[nx][ny]:
                                visited[nx][ny] = 1
                                q.append((nx, ny))
                count += 1

    results.append(count)

for e in results:
    print(e)
