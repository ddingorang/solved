import sys
from collections import defaultdict, deque

n = int(sys.stdin.readline().rstrip())
tree = defaultdict(list)
for _ in range(n-1) : # 트리 만들기
    one, two = map(int, sys.stdin.readline().rstrip().split(' '))
    tree[one].append(two)
    tree[two].append(one)

q = deque()
visited = [0 for _ in range(n+1)] # 방문 여부 체크
q.append((1, 0)) # 루트 삽입, (노드 번호, 깊이)
r = defaultdict(int) # 노드 별 깊이 저장
result = []
while q :
    curn, curd = q.popleft()
    visited[curn] = 1
    for e in tree[curn]:
        if visited[e] == 0:
            q.append((e, curd + 1))
            r[e] = curd + 1 # 노드 별 깊이 저장

for i in range(2, n+1) :
    tmp = 100001
    idx = 0
    for elm in tree[i] : # 위, 아래로 연결된 노드가 있으면
        if tmp > r[elm] :
            tmp = r[elm]
            idx = elm
    result.append(idx) # 그 중 깊이가 작은 노드가 부모 노드임

for element in result :
    print(element)