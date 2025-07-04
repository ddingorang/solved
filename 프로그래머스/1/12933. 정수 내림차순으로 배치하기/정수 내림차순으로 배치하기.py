def solution(n):
    new_n = list(str(n))
    
    new_n.sort(reverse=True)
    
    s = ''
    for n in new_n:
        s += n
    answer = int(s)
    return answer