import sys
from collections import defaultdict, deque

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
visited = [0 for _ in range(n+1)]
friends = defaultdict(list)
q = deque()

for _ in range(m) : # 인접 리스트
    a, b = map(int, sys.stdin.readline().rstrip().split(' '))
    friends[a].append(b)
    friends[b].append(a)

q.append((1, 0)) # 상근이부터 시작
count = 0
while q :
    curi, curd = q.popleft()
    visited[curi] = 1

    for e in friends[curi] :
        if visited[e] == 0 :
            if curd+1 == 3 : # 깊이 2까지가 친구의 친구임
                continue
            visited[e] = 1
            q.append((e, curd+1))
            count += 1

print(count)