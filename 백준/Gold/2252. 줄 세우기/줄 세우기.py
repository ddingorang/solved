from collections import deque

n, m = map(int, input().split(' '))
l = [[] for _ in range(n+1)]
indegree = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split(' '))
    l[a].append(b)
    indegree[b] += 1

q = deque()
result = []
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    result.append(cur)
    for e in l[cur]:
        indegree[e] -= 1
        if indegree[e] == 0:
            q.append(e)

for e in result:
    print(e, end=' ')


