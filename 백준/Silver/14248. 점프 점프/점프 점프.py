import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
stones = list(map(int, sys.stdin.readline().rstrip().split(' ')))
s = int(sys.stdin.readline().rstrip())
q = deque()
visited = [0 for _ in range(n+1)]
d = [-1, 1]
count = 0

q.append((s, stones[s-1]))
count += 1
while q:
    cur = q.popleft()
    visited[cur[0]] = 1
    for e in d :
        next = cur[0] + (e * cur[1])
        if 1 <= next <= n and visited[next] == 0 :
            q.append((next, stones[next-1]))
            count += 1

print(count)
