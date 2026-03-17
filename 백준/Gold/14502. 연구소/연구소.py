from collections import deque
from itertools import combinations

n, m = map(int, input().split(' '))
field = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for _ in range(n) :
    row = list(map(int, input().split(' ')))
    field.append(row)

# 빈칸인 좌표만 추출
empty_spaces = [(r, c) for r in range(n) for c in range(m) if field[r][c] == 0]
# 빈칸 중에서만 3개 선택
possible = list(combinations(empty_spaces, 3))

result = []
for p in possible:
    newfield = [row[:] for row in field]
    for pp in p:
        i = pp[0]
        j = pp[1]
        if field[i][j] == 0:
            newfield[i][j] = 1

    q = deque()
    for j in range(n):
        for k in range(m):
            if newfield[j][k] == 2:
                q.append((j, k))

    while q:
        curx, cury = q.popleft()
        for d in range(4):
            nx = curx + dx[d]
            ny = cury + dy[d]
            if 0 <= nx < n and 0 <= ny < m:
                if newfield[nx][ny] == 0:
                    newfield[nx][ny] = 2
                    q.append((nx, ny))

    temp = 0
    for j in range(n):
        for k in range(m):
            if newfield[j][k] == 0:
                temp += 1

    result.append(temp)

print(max(result))