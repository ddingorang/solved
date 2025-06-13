import itertools
def solution(k, dungeons):
    answer = 0
    poss = list(itertools.permutations(dungeons))
    result = []
    for p in poss :
        ch = k
        success = True
        cnt = 0
        for a in p :
            if a[0] > ch : 
                success = False
                break
            else :
                ch -= a[1]
                cnt += 1
        result.append(cnt)
        
    answer = max(result)
    return answer