t = int(input())

# 1로만 표현하는 경우의 수는 하나
dp = [1] * 10001

# 뒤에 2만 더해 주어서 표현할 수 있는 경우의 수 더하기
for i in range(2, 10001):
    dp[i] += dp[i - 2]

# 뒤에 3만 더해 주어서 표현할 수 있는 경우의 수 더하기
for i in range(3, 10001):
    dp[i] += dp[i - 3]

for _ in range(t):
    n = int(input())
    print(dp[n])