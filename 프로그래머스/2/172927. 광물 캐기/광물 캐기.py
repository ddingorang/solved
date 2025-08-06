def solution(picks, minerals):
    answer = 0
    dict = {'diamond' : 25, 'iron' : 5, 'stone' : 1}
    sum_picks = sum(picks)
    inven = list()
    for i in range(sum_picks) :
        s = minerals[i*5 : i*5 + 5]
        count = 0
        if len(s) != 0 :
            for j in s :
                count += dict[j]
            inven.append([s,count,i])
    inven.sort(key = lambda x : x[1])
    l = len(inven)
    while len(inven) != 0 :
        if picks[0] != 0 :
            answer += len(inven[-1][0])
            inven.pop()
            picks[0] -= 1
        elif picks[1] != 0 :
            for i in inven[-1][0] :
                if i == 'diamond' :
                    answer += 5
                else :
                    answer += 1
            inven.pop()
            picks[1] -= 1
        else :
            for i in inven[-1][0] :
                if i == 'diamond' :
                    answer += 25
                elif i == 'iron' : 
                    answer += 5
                else :
                    answer += 1
            inven.pop()
            picks[2] -= 1
    return answer