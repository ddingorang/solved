from collections import deque
def solution(priorities, location):
    q = deque(priorities)
    idx = deque()
    for i in range(len(priorities)) :
        idx.append(i)
    result = []
    while q:
        if q[0] != max(q) :
            pp = q.popleft()
            idxx = idx.popleft()
            q.append(pp)
            idx.append(idxx)
        else :
            q.popleft()
            result.append(idx.popleft())

    answer = result.index(location) + 1
    return answer