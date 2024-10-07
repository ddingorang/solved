import sys
from collections import defaultdict, deque

n = int(sys.stdin.readline().rstrip())
a, b = map(int, sys.stdin.readline().split(' '))
m = int(sys.stdin.readline().rstrip())
f = defaultdict(list) # 그래프 기록
visited = [0 for _ in range(n+1)] # 방문 여부
depth = [0 for _ in range(n+1)] # 깊이 기록
found = False # 찾은 여부
for _ in range(m) :
    one, two = map(int, sys.stdin.readline().split(' '))
    f[one].append(two)
    f[two].append(one) # 그래프 만들기

q = deque()
q.append((a, 0)) # 시작 append
while q :
    curn, curd = q.popleft() # pop하고
    if visited[curn] == 0 : # 방문 안했으면
        depth[curn] = curd # 그 노드의 깊이 기록
        for e in f[curn] : # 인접 노드 순회
            if visited[e] == 0 : # 방문 안했으면
                visited[curn] = 1 # 방문 처리
                q.append((e, curd + 1)) # 깊이를 1 증가시키고 append
            if e == b : # 찾았으면
                found = True # 찾은 여부 true로 하고 break
                break

if found == False : # 못 찾았으면
    print(-1)
else : # 찾았으면
    print(depth[b])