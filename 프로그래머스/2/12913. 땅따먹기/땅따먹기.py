def solution(land):
    answer = 0
    for i in range(1,len(land)) :
        for j in range(4) : 
            # dp 사용
            # 같은 열의 원소 제외한 나머지 세 원소 중 최대값
            land[i][j] += max(land[i-1][k] for k in range (4) if k != j)
            
    answer = max(land[-1])
    return answer