import sys

n = int(sys.stdin.readline().rstrip())
nl = []
dist =[[float('inf') for _ in range(n)] for _ in range(n)]
for _ in range(n) :
    nl.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))

for a in range(n):
    for b in range(n):
        if nl[a][b] != 0:
            dist[a][b] = nl[a][b]

for k in range(n):
    for i in range(n):
        for j in range(n):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

for x in range(n) :
    for y in range(n) :
        if dist[x][y] == float('inf') :
            dist[x][y] = 0
        else :
            dist[x][y] = 1
        print(f'{dist[x][y]} ', end='')
    print()