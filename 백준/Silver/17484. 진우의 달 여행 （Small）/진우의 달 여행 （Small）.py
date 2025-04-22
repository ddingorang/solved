n, m = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 1, 1]
dy = [-1, 0, 1]
dir_map = [-1, 0, 1]

min_cost = float('inf')

for i in range(m):
    stack = [(0, i, -2, space[0][i])]  # (x, y, prev_dir, cost)

    while stack: # stack을 활용한 dfs
        x, y, prev_dir, cost = stack.pop()
        # 세로, 가로, 직전 이동 방향, 비용

        if x == n - 1: # 맨 아래로 도달했을 때
            min_cost = min(min_cost, cost)
            continue

        for k in range(3):
            nx = x + dx[k]
            ny = y + dy[k]
            next_dir = dir_map[k]

            if 0 <= nx < n and 0 <= ny < m:
                if next_dir != prev_dir: # 이전 이동 방향과 다를 때에만
                    stack.append((nx, ny, next_dir, cost + space[nx][ny]))

print(min_cost)
