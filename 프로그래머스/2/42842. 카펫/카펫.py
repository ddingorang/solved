def solution(brown, yellow):
    answer = []
    
    # yellow의 약수 찾기
    result = set()
    for i in range(1, int(yellow**0.5) + 1):
        if yellow % i == 0:
            result.add(i)
            result.add(yellow // i)
    result = list(sorted(result))
    
    # yellow의 가로*세로 곱 경우의 수 찾기
    for r in result:
        row = yellow // r
        col = r
        # yellow의 테두리를 감싸는 brown 개수
        if 2*(row+col) + 4 == brown:
            answer = [row + 2, col + 2]
            break
        
    return answer

