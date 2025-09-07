def solution(n):
    answer = ''
    s = '124'
    while n>0 :
        # 0은 없음
        n -= 1
        answer = s[n%3] + answer
        n //= 3
        
    return answer