
T = int(input())
result = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 입력 받기
    N, K = map(int, input().split())
    items = [tuple(map(int, input().split())) for _ in range(N)]

    # DP 배열 초기화: dp[w]는 "부피 w까지 담을 수 있을 때의 최대 가치"
    dp = [0] * (K + 1)

    # 각 아이템을 순회하며 DP 배열 갱신
    for v, c in items:
        for w in range(K, v - 1, -1):  # 뒤에서부터 순회 (중복 선택 방지)
            dp[w] = max(dp[w], dp[w - v] + c)

    # 결과: 최대 가치
    result.append(dp[K])

for index, r in enumerate(result):
    print(f'#{index+1} {r}')