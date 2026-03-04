from collections import defaultdict, deque
import sys

# 백준에서는 재귀 깊이 제한이나 입력 속도 최적화가 중요합니다.
input = sys.stdin.readline

n = int(input())
if n == 1:
    print(0)
    exit()

g = defaultdict(list)
for _ in range(n - 1):
    a, b, w = map(int, input().split())
    g[a].append((b, w))
    g[b].append((a, w))


def bfs(start_node):
    # 가장 먼 노드와 그 거리를 반환하는 함수
    max_dist = -1
    farthest_node = start_node

    q = deque([(start_node, 0)])
    visited = [-1] * (n + 1)
    visited[start_node] = 0

    while q:
        curr, curr_w = q.popleft()  # BFS를 위해 popleft 사용

        if curr_w > max_dist:
            max_dist = curr_w
            farthest_node = curr

        for neighbor, weight in g[curr]:
            if visited[neighbor] == -1:  # 방문하지 않은 경우
                visited[neighbor] = curr_w + weight
                q.append((neighbor, visited[neighbor]))

    return farthest_node, max_dist


# 1. 임의의 노드(1번)에서 가장 먼 노드 A를 찾음
node_a, _ = bfs(1)

# 2. 노드 A에서 가장 먼 노드 B까지의 거리를 찾음
_, total_max_dist = bfs(node_a)

print(total_max_dist)