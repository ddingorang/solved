def solution(n):
    ln = list(str(n))
    
    answer = []
    for i in range(len(ln)-1, -1, -1) :
        answer.append(int(ln[i]))
    return answer