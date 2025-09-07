def solution(m, n, puddles):
    MOD = 1_000_000_007

    # DP 테이블 초기화 (1-indexed 사용)
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    # 시작점 초기화
    dp[1][1] = 1

    # 물웅덩이 위치를 -1로 표시
    for x, y in puddles:
        dp[y][x] = -1  # 좌표 변환 (문제는 (x, y), 배열은 (y, x))

    # DP 테이블 채우기
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            # 시작점이거나 물웅덩이면 건너뛴다
            if (i == 1 and j == 1) or dp[i][j] == -1:
                continue

            # 위쪽에서 오는 경우 (이동 가능하면)
            if dp[i - 1][j] != -1:
                dp[i][j] += dp[i - 1][j] % MOD

            # 왼쪽에서 오는 경우 (이동 가능하면)
            if dp[i][j - 1] != -1:
                dp[i][j] += dp[i][j - 1] % MOD

            # MOD 연산 적용
            dp[i][j] %= MOD
            
    print(dp)
    answer = dp[n][m]
    return answer