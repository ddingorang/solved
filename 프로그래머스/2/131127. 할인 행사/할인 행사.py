from collections import defaultdict
def solution(want, number, discount):
    answer = 0
    d = defaultdict(int)
    for i in range(len(want)) :
        d[want[i]] += number[i]
    
    for j in range(len(discount)-9) :
        temp = discount[j:j+10]
        tempdict = {e : temp.count(e) for e in want}
        
        # 딕셔너리 동등비교
        if tempdict == d :
            answer += 1
        
    return answer