def solution(n):
    answer = 0
    if n==1 :
        answer = 1
    if n==2 :
        answer = 2
    else :
        dp = [0, 1, 2]
        for i in range(3, n+1) :
            dp.append((dp[i-1] + dp[i-2]) % 1234567)
        answer = dp[n]
    return answer