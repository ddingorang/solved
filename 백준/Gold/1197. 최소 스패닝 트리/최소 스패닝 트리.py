import sys
from queue import PriorityQueue

sys.setrecursionlimit(10**6)

def find(a) :
    if a == parent[a]:
        return a
    else :
        parent[a] = find(parent[a])
        return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if(a != b):
        parent[b] = a

v, e = map(int, input().split(' '))
parent = [0] * (v+1)
pq = PriorityQueue()

for i in range(1, v+1) :
    parent[i] = i

for i in range(e):
    a, b, c = map(int, input().split(' '))
    pq.put((c, a, b)) # 제일 앞 값 기준으로 정렬 -> 가중치를 맨 앞으로

result = 0
usedEdge = 0
while usedEdge < v-1:
    w, a, b = pq.get() # 가중치가 작은 순서대로 get
    if find(a) != find(b) : # 루트가 같지 않으면, 잇는다
        union(a, b)
        result += w # 가중치 누적
        usedEdge += 1 # 간선 개수 하나 증가

print(result)