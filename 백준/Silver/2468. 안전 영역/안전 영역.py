import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
area = [] # 지역 높이 정보
numbers = set() # 높이 값들의 집합
for _ in range(n) :
    one = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    for e in one:
        numbers.add(e) # 집합에도 추가
    area.append(one)

q = deque() # bfs를 위한 덱
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
result = [] #

for elm in numbers: # 지역 내의 모든 높이 값들에 대해 브루트포스
    visited = [[0 for _ in range(n)] for _ in range(n)]
    count = 0
    for x in range(n) :
        for y in range(n) :
            if visited[y][x] != 1 and area[y][x] >= elm :
                q.append((y, x))
                while q :
                    cury, curx = q.popleft()
                    for i in range(4) :
                        newy = cury + dy[i]
                        newx = curx + dx[i]
                        if 0 <= newy < n and 0 <= newx < n :
                            if visited[newy][newx] != 1 and area[newy][newx] >= elm:
                                q.append((newy, newx))
                                visited[newy][newx] = 1
                count += 1
    result.append(count)

print(max(result)) # 그 중에 최대값