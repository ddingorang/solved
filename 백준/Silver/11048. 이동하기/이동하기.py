import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
miro = []
dp = [[0 for _ in range(m)] for _ in range(n)]
for _ in range(n) :
    miro.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))

# dp[i][j] : i행 j열까지 왔을 때까지 모은 최대 사탕 갯수
# dp[0][0] : miro[0][0]과 같음
# dp[0][j] : 왼쪽 열의 값을 더하는 경우 밖에 없음 => 그것이 최대일 수 밖에 없음
# dp[i][0] : 윗 행의 값을 더하는 경우 밖에 없음 => 그것이 최대일 수 밖에 없음
# 위를 제외한 dp[i][j] : 왼쪽 열의 값과 위쪽 행의 값을 비교하여, 큰 것을 더함

for i in range(n) :
    for j in range(m) :
        if i == 0 and j == 0 :
            dp[0][0] = miro[0][0]
        elif i == 0 :
            dp[i][j] = dp[i][j-1] + miro[i][j]
        elif j == 0 :
            dp[i][j] = dp[i-1][j] + miro[i][j]
        else :
            dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + miro[i][j]

print(dp[n-1][m-1])