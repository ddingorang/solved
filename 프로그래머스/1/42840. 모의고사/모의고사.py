def solution(answers):
    answer = []
    
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    onecnt = 0
    twocnt = 0
    threecnt = 0
    for idx, a in enumerate(answers):
        if a == one[idx%5] :
            onecnt += 1
        if a == two[idx%8] :
            twocnt += 1
        if a == three[idx%10] :
            threecnt += 1
    temp = [onecnt, twocnt, threecnt]
    
    for i in range(len(temp)) :
        if temp[i] == max(temp) :
            answer.append(i+1)
    
    return answer