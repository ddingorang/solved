def solution(n, left, right):
    answer = []
    for i in range(left+1, right+2) :
        ir = (i-1) // n + 1
        ic = i % n
        if ic % n == 0 :
            ic = n
        if ic < ir :
            answer.append(ir)
        else :
            answer.append(ic)
            
    
    return answer