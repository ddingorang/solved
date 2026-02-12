
n = int(input(''))
scores = []
dp = [0 for _ in range(n)]
for _ in range(n):
    scores.append(int(input('')))

# dp[n] => n번째 계단까지 밟았을 때 최대 점수
dp[0] = scores[0]
if n>= 2:
    dp[1] = scores[0] + scores[1] # 1번, 2번 모두 밟을 때가 최대
if n>=3 :
    dp[2] = max(scores[0] + scores[2], scores[1] + scores[2]) # 1번+3번, 2번+3번 중 큰 방법

    for i in range(3, n) :
        # 1) 3번 전의 계단을 밟고, 바로 전과 현재 계단 밟기
        # 2) 2번 전의 계단을 밟고, 현재 계단 밟기
        # 둘 중에 최대
        dp[i] = max(dp[i-3] + scores[i-1] + scores[i], dp[i-2] + scores[i])

print(dp[-1])