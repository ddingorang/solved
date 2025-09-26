from collections import defaultdict
def solution(clothes):
    cl = defaultdict(list)
    for c in clothes:
        cl[c[1]].append(c[0])
    
    init = 1
    # 경우의 수 = (a+1)(b+1)(c+1)(...) - 1
    for t in cl.values():
        init *= (len(t) + 1)
    
    answer = init-1
    return answer