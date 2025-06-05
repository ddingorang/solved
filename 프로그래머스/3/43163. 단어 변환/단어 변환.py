from collections import defaultdict, deque

def word_diff_one(w1, w2):
    # 단어 두 개가 한 글자만 다르면 True
    diff = 0
    for a, b in zip(w1, w2):
        if a != b:
            diff += 1
        if diff > 1:
            return False
    return diff == 1

def solution(begin, target, words):
    if target not in words:
        return 0

    graph = defaultdict(list)
    words.append(begin)

    # 그래프 구성
    for i in range(len(words)):
        for j in range(i + 1, len(words)):
            if word_diff_one(words[i], words[j]):
                graph[words[i]].append(words[j])
                graph[words[j]].append(words[i])

    visited = defaultdict(bool)
    q = deque([(begin, 0)])
    visited[begin] = True

    while q:
        current, count = q.popleft()
        if current == target:
            return count
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                q.append((neighbor, count + 1))

    return 0
