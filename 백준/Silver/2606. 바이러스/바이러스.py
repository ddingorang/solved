import sys
from collections import defaultdict
from collections import deque

n = int(sys.stdin.readline().rstrip())
p = int(sys.stdin.readline().rstrip())
l = defaultdict(list)
q = deque()
count = 0
visited = [0 for _ in range(n+1)]
for _ in range(p) :
    k, v = map(int, sys.stdin.readline().split(' '))
    l[k].append(v)
    l[v].append(k)

q.append(1)
visited[1] = 1
while q:
    cur = q.popleft()
    for e in l[cur] :
        if visited[e] == 0:
            count += 1
            q.append(e)
            visited[e] = 1

print(count)
