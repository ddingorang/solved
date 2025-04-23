from collections import deque

n, m = map(int, input().split())  # n: 사다리 개수, m: 뱀 개수
ls = [list(map(int, input().split())) for _ in range(n + m)]

# 사다리/뱀 정보를 딕셔너리로 저장
warp = {start: end for start, end in ls}

# 방문 체크
# 무한 루프를 방지하기 위해
visited = [False] * 101

# BFS 사용
q = deque()
q.append((1, 0))  # (현재 위치, 이동 횟수)
visited[1] = True # 1부터 시작

while q:
    pos, cnt = q.popleft()

    for move in range(1, 7):
        next_pos = pos + move
        if next_pos > 100: # 100을 초과하면 이동할 수 없음
            continue

        # 사다리 또는 뱀 처리
        if next_pos in warp:
            next_pos = warp[next_pos]

        if not visited[next_pos]:
            if next_pos == 100: # 딱 100이 되었을 때 정지
                print(cnt + 1)
                exit()
            visited[next_pos] = True
            q.append((next_pos, cnt + 1))
