import sys
from collections import deque
s, e = map(int, sys.stdin.readline().split(' '))

d = lambda x:x*2
b = lambda x:x-1
f = lambda x:x+1
l = [d, b, f]
q = deque()
afterfunc = 0 # 연산 이후 값
visited = [0 for _ in range(200001)]
q.append(s) # 시작부터 append
visited[s] = 1
while 1:
    cur = q.popleft()
    if cur == e : # 찾았으면
        print(visited[cur]-1) # 그 때의 깊이 출력
        break
    for em in l :
        afterfunc = em(cur) # 셋 중 하나의 연산 결과
        if afterfunc > 200000 or afterfunc < 0: continue # 범위 초과하면 제외
        if visited[afterfunc] != 0 : continue # 이미 방문한 숫자면 패스
        q.append(afterfunc) # 큐에 넣고
        visited[afterfunc] = visited[cur] + 1 # 깊이가 증가