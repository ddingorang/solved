from collections import defaultdict
def solution(participant, completion):
    l = defaultdict(int)
    for e in participant:
        l[e] += 1
    for c in completion:
        l[c] -= 1
        if l[c] == 0 : del l[c]
    
    answer = list(l.keys())
    return answer[0]