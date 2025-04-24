def solution(k, ranges):
    points = [k]
    result = []
    s = 0
    while k != 1 :
        if k % 2 == 0 :
            k /= 2
        else :
            k = k*3 + 1
        points.append(k)
    
    #print(points)
    for e in ranges:
        if e[0] == 0 and e[0] == e[1] :
            if k == 2:
                result.append(1.5)
            else :
                s = (points[0] + points[len(points)-1] + 2 * sum(points[1 : len(points)-1])) / 2
                result.append(s)
        else :
            f = int(e[0])
            r = int(len(points)-1 + e[1])
            if r == f:
                result.append(0)
            elif r < f :
                result.append(-1)
            elif r-f == 1:
                result.append((points[f] + points[r]) / 2)
            else : 
                s = (points[f] + points[r] + 2 * sum(points[f+1 : r])) / 2
                result.append(s)
    
    answer = result
    return answer