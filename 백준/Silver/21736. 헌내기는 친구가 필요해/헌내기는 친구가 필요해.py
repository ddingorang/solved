import sys
from collections import deque

n, m= map(int, sys.stdin.readline().split(' ')) # 세로 크기(n), 가로 크기(m)
visited = [[0 for _ in range(m)] for _ in range(n)] # 방문 여부 체크하는 배열
c = [] # 캠퍼스 정보
dx = [1, 0, -1, 0] # 가로의 변위
dy = [0 ,1, 0, -1] # 세로의 변위
count = 0 # 사람을 만난 횟수 저장

for _ in range(n) :
    c.append(list(sys.stdin.readline().rstrip())) # 캠퍼스 정보 한 줄씩 입력 받음

for i in range(n) :
    for j in range(m) :
        if c[i][j] == 'I' : # 도연이의 위치를 파악
            sy, sx = i, j # 위치 저장
            break

q = deque() # bfs를 위한 deque
q.append((sy, sx)) # 파악한 위치에서 시작
visited[sy][sx] = 1 # 방문 처리
while q:
    cur = q.popleft() # 앞에서 pop
    for k in range(4) : # 상, 하, 좌, 우 방향을 고려
        newy = cur[0] + dy[k] # 이동한 새로운 세로 좌표
        newx = cur[1] + dx[k] # 이동한 새로운 가로 좌표
        if newy >= 0 and newy < n and newx >= 0 and newx < m : # 캠퍼스 크기 내 유효한 위치일 때
            if visited[newy][newx] == 0 and c[newy][newx] != 'X': # 이동한 위치가 방문한 적이 없고, 벽이 아닐 때
                q.append((newy, newx)) # deque에 append
                visited[newy][newx] = 1 # 방문 처리
                if c[newy][newx] == 'P' : # 사람 만났다면?
                    count += 1 # count 하나 증가

if count == 0: # 한 명도 만나지 못했다면
    print('TT')
else :
    print(count)
