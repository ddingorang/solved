def solution(numbers):
    strn = list(map(str, numbers))
    
    # 문자열을 3번 반복한 것을 비교
    strn.sort(key = lambda x: x*3, reverse = True)
    return str(int(''.join(strn)))
    