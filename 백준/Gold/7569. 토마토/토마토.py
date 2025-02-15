from collections import deque
import sys
input = sys.stdin.readline
dx = [1,-1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]

def bfs():
    while queue:
        tx,ty,tz = queue.popleft()
        visited[tz][tx][ty] = 1
        for i in range(6):
            x = tx+dx[i]
            y = ty+dy[i]
            z = tz+dz[i]
            if 0<=x<n and 0<=y<m and 0<=z<h and box[z][x][y]==0 and visited[z][x][y]==0:
                queue.append([x,y,z])
                box[z][x][y] = box[tz][tx][ty] + 1
                visited[z][x][y] = 1
                
m,n,h = map(int,input().split())
box = [[] for i in range(h)]
visited = [[[0 for i in range(m)] for i in range(n)] for i in range(h)]
queue = deque()
isTrue = False

for i in range(h):
    for j in range(n):
        box[i].append(list(map(int,input().split())))
for z in range(h):
    for x in range(n):
        for y in range(m):
            if box[z][x][y] == 1:
                queue.append([x,y,z])
                
bfs()
max_num = 0
for z in range(h):
    for x in range(n):
        for y in range(m):
            if box[z][x][y] == 0:
                isTrue = True
            max_num = max(max_num, box[z][x][y])
if isTrue == True:
    print(-1)
else:
    print(max_num - 1)