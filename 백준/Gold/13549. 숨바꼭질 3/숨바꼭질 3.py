from collections import deque

n, k = map(int, input('').split(' '))
maxx = 100000

dist = [float('inf')] * (maxx+1)
dist[n] = 0

# 0-1 bfs
# 간단한 다익스트라
# 비용 0은 앞에, 1은 뒤에 삽입
# 작은 비용부터 탐색됨
q = deque()
q.append(n)

while q:
    cur = q.popleft()

    if cur == k:
        print(dist[cur])
        break

    twice = cur*2
    if 0<=twice<=maxx and dist[twice] > dist[cur]:
        dist[twice] = dist[cur]
        q.appendleft(twice) # 비용이 0인 이동은 앞에

    for walk in (cur-1, cur+1) :
        if 0<=walk<=maxx and dist[walk] > dist[cur]+1:
            dist[walk] = dist[cur]+1
            q.append(walk) # 비용이 1인 이동은 뒤에