import sys
from collections import deque

# 입력 속도 최적화
input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    
    # 역방향 인접 리스트: adj[B]에 A를 넣으면, B를 해킹했을 때 영향을 받는 A들을 바로 탐색 가능
    adj = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        adj[b].append(a)

    def bfs(start_node):
        count = 1
        queue = deque([start_node])
        visited = [False] * (n + 1)
        visited[start_node] = True
        
        while queue:
            curr = queue.popleft()
            for neighbor in adj[curr]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    count += 1
                    queue.append(neighbor)
        return count

    max_cnt = 0
    results = []

    # 각 노드별로 해킹 가능한 컴퓨터 수 측정
    for i in range(1, n + 1):
        if adj[i]: # 연결된 노드가 있는 경우만 BFS 실행 (소소한 최적화)
            cnt = bfs(i)
            if cnt > max_cnt:
                max_cnt = cnt
                results = [i]
            elif cnt == max_cnt:
                results.append(i)
        else:
            # 연결된 게 없어도 자기 자신은 1개 해킹 가능
            if max_cnt < 1:
                max_cnt = 1
                results = [i]
            elif max_cnt == 1:
                results.append(i)

    # 결과 출력
    print(*(sorted(results)))

solve()