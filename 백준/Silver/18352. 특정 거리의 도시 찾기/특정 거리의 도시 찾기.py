from collections import deque, defaultdict
import sys

# 입력이 많을 경우 시간 초과를 방지하기 위해 sys.stdin.readline 사용 권장
input = sys.stdin.readline 

n, m, k, x = list(map(int, input().split()))
g = defaultdict(list)

for _ in range(m):
    a, b = tuple(map(int, input().split()))
    g[a].append(b)

q = deque()
v = [False for _ in range(n+1)]
possible = []

# 시작 노드 초기화 및 방문 처리
q.append((x, 0))
v[x] = True # <--- 이 부분이 반드시 필요합니다!

while q:
    curn, curd = q.popleft()
    
    # 현재 거리가 k와 같다면 정답 리스트에 추가
    if curd == k:
        possible.append(curn)
        continue
        
    for nd in g[curn]:
        if not v[nd]:
            v[nd] = True
            q.append((nd, curd+1))

if len(possible) == 0:
    print(-1)
else:
    possible.sort() # <--- 오름차순 정렬 추가
    for e in possible:
        print(e)