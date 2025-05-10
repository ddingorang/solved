from collections import defaultdict

def solution(keymap, targets):
    answer = []
    d = defaultdict(lambda: float('inf'))  # 초기값을 무한대로 설정

    for e in keymap:
        for i, char in enumerate(e):
            d[char] = min(d[char], i + 1)  # 최소 횟수 갱신

    for t in targets:
        total = 0
        for l in t:
            if d[l] == float('inf'):  # keymap에 없는 문자
                total = -1
                break
            total += d[l]
        answer.append(total)

    return answer
