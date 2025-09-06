from collections import deque

def solution(places):
    answer = []
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    for c in range(5) :
        status = 1
        for i in range(5) :
            for j in range(5) :
                if places[c][i][j] == 'P' :
                    visited = [[0 for _ in range(5)] for _ in range(5)]
                    q = deque()
                    q.append((i, j, 'P'))
                    while q :
                        curi, curj, curs = q.popleft()
                        visited[curi][curj] = 1
                        
                        if curs == 'PP' or curs == 'POP' :
                            status = 0
                            break
                        if len(curs) == 3 : 
                            continue
                        for k in range(4) :
                            nx = curi + dx[k]
                            ny = curj + dy[k]
                            
                            if 0 <= nx < 5 and 0 <= ny < 5 and visited[nx][ny] == 0:
                                ns = places[c][nx][ny]
                                q.append((nx, ny, curs+ns))
        answer.append(status)
                
    return answer