def solution(elements):
    ext = elements*2
    # 원형 수열 : 원래 수열을 2배로 만들어 보기
    poss = set()
    for i in range(1, len(elements)+1) :
        for j in range(len(ext)-i) :
            s = sum(ext[j:j+i])
            poss.add(s)
            
    answer = len(poss)
    return answer