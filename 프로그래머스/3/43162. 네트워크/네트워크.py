from collections import deque, defaultdict
def solution(n, computers):
    answer = 0
    net = defaultdict(list)
    for i in range(n) :
        for j in range(n) :
            if i == j : continue
            if computers[i][j] == 1 :
                net[i+1].append(j+1)
    
    visited = [False for _ in range(n+1)]
    
    q = deque()
    for k in range(1, n+1) :
        if visited[k] == False:
            q.append(k)
            while q:
                cur = q.popleft()
                for e in net[cur] :
                    if visited[e] == False :
                        q.append(e)
                        visited[e] = True
            answer += 1
    
    return answer
    