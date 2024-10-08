import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
nl = []
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
visited =[[0 for _ in range(n)] for _ in range(n)]
r = []
for _ in range(n) :
    nl.append(list(sys.stdin.readline().rstrip()))
q = deque()

for i in range(n) :
    for j in range(n) :
        if visited[i][j] == 0 and nl[i][j] != '0':
            count = 1
            q.append((i, j))
            visited[i][j] = 1
            while q:
                curi, curj = q.popleft()
                for k in range(4):
                    newi = curi + dy[k]
                    newj = curj + dx[k]
                    if 0 <= newi < n and 0 <= newj < n :
                        if visited[newi][newj] == 0 and nl[newi][newj] != '0' :
                            q.append((newi, newj))
                            count += 1
                            visited[newi][newj] = 1
            r.append(count)

print(len(r))
r.sort()
for e in r:
    print(e)