from collections import deque
def solution(order):
    answer = 0
    q = deque()
    i = 1
    cnt = 0
    for o in order :
        while i != o and i < o:
            q.append(i)
            i += 1
        if i == o :
            cnt += 1
            i += 1
            continue
        if q[-1] == o:
            q.pop()
            cnt += 1
            continue
        else :
            break
    
    answer = cnt
    return answer