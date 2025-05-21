from datetime import date, timedelta
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, T + 1):
    dl = list(map(int, input().split(' ')))
    fm, fd = dl[0], dl[1]
    sm, sd = dl[2], dl[3]
    firstdate = date(2025,fm, fd)
    seconddate = date(2025, sm, sd)
    # timedelta = 날짜 간 연산
    datediff = seconddate - firstdate

    result.append(datediff.days + 1)

for idx, e in enumerate(result):
    print(f'#{idx+1} {e}')