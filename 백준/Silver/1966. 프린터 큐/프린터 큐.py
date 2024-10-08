import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
r = []
for _ in range(n) :
    n, m = map(int, sys.stdin.readline().split(' '))
    doc = list(map(int, sys.stdin.readline().split(' ')))
    newdoc = [(i, v) for i, v in enumerate(doc)]
    mx = max(doc)
    count = 0
    q = deque(newdoc)
    while q :
        curi, curv = q.popleft()
        if curv < mx :
            q.append((curi, curv))
        else :
            count += 1
            doc.remove(curv)
            if doc :
                mx = max(doc)
            if curi == m:
                break
    r.append(count)

for e in r :
    print(e)