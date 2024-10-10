import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
q = deque()
result = []
balloons = list(map(int, sys.stdin.readline().split(' ')))
for idx, b in enumerate(balloons) :
    q.append((b, idx+1))
num = q.popleft()[0]
result.append(1)

while q:
    if num > 0 :
        for _ in range(num-1):
            q.append(q.popleft())
        num, idx = q.popleft()
    else :
        for _ in range(abs(num)-1):
            q.appendleft(q.pop())
        num, idx = q.pop()
    result.append(idx)

for e in result :
    print(e, end=' ')