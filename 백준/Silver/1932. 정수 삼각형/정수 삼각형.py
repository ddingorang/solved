import sys

n = int(sys.stdin.readline().rstrip())
l = []
for _ in range(n) :
    l.append(list(map(int, sys.stdin.readline().split(' '))))

dp = [[0 for _ in range(n)] for _ in range(n)]
# dp = 어떤 위치까지 더했을 때 최대값을 저장하는 배열
dp[0][0] = l[0][0]
for i in range(1, n) :
    for j in range(i+1) :
        dp[i][j] += l[i][j] # 일단 그 위치의 수는 더하고
        if j == 0 : # 맨 왼쪽 열일 경우
            dp[i][j] += dp[i-1][j] # 그 바로 윗 행의 맨 왼쪽 열밖에 더할 것이 없음
        elif j == i : # 맨 오른쪽 열일 경우
            dp[i][j] += dp[i-1][j-1] # 그 바로 윗 행의 맨 오른쪽 열밖에 더할 것이 없음
        else :
            if dp[i-1][j-1] > dp[i-1][j] : # 왼쪽 위가 더 크면
                dp[i][j] += dp[i-1][j-1] # 왼쪽 위까지의 덧셈이 최대
            else : # 오른쪽 위가 더 크면
                dp[i][j] += dp[i-1][j] # 오른쪽 위까지의 덧셈이 최대

print(max(dp[n-1]))
# dp 배열의 맨 마지막 행 중의 최댓값이 선택한 수들의 합의 최대값