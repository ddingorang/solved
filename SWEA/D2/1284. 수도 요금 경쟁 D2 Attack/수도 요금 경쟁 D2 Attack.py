T = int(input())
result = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    p, q, r, s, w = map(int, input().split())
    a = p * w
    b = 0
    if w <= r :
        b = q
    else :
        b = (w-r) * s + q

    result.append(min(a, b))

for idx, val in enumerate(result):
    print(f'#{idx+1} {val}')
    # ///////////////////////////////////////////////////////////////////////////////////