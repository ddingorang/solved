from collections import deque

def solution(x, y, n):
    queue = deque()
    queue.append((x, 0))  # 시작 값과 연산 횟수
    visited = set()
    visited.add(x)
    
    while queue:
        current, count = queue.popleft()
        
        if current == y:
            return count
        
        # 다음에 시도할 수 있는 연산들
        for next_value in (current + n, current * 2, current * 3):
            if next_value <= y and next_value not in visited:
                visited.add(next_value)
                queue.append((next_value, count + 1))
    
    # BFS를 다 돌았는데도 못 도달하면 -1 반환
    return -1
