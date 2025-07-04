from collections import defaultdict
def solution(k, tangerine):
    t = defaultdict(int)
    # 종류별 개수 딕셔너리에 저장
    for e in tangerine:
        t[e] += 1
    
    # 개수 내림차순으로 정렬
    sorted_t = sorted(t.items(), key=lambda x:-x[1])
    
    n = 0
    for t, cnt in sorted_t:
        if k <= 0: break
        k -= cnt
        n += 1
        
    answer = n
    return answer