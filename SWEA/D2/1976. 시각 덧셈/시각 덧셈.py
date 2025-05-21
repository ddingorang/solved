
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, T + 1):
    h1, m1, h2, m2= list(map(int, input().split(' ')))
    h = h1 + h2
    m = m1 + m2
    if m >= 60 :
        m -= 60
        h += 1
    if h > 12 :
        h -= 12

    result.append((h, m))

for idx, e in enumerate(result):
    print(f'#{idx+1} {e[0]} {e[1]}')