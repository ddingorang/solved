def solution(n):
    answer = 0
    onecount = 0
    first = True
    while True:
        digits = []
        temp = n
        while temp != 0 :
            if temp % 2 == 1:
                digits.append(1)
            temp = temp//2
        
        if first :
            onecount = len(digits)
            first = False
            n += 1
            continue
        
        if len(digits) == onecount :
            break
        
        n += 1
            
    answer = n
    return answer