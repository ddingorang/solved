def solution(array, commands):
    result = []
    for c in commands:
        # 먼저 슬라이싱
        newarr = array[c[0] - 1 : c[1]]
        
        # 정렬하고
        newarr.sort()
        
        # k번째 숫자 append
        result.append(newarr[c[2]-1])
    
    return result