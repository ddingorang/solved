
T = int(input())
result = []
money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    i = int(input())
    cnt = []
    for m in money:
        if i // m > 0 :
            cnt.append(i // m)
            i -= (m * (i // m))
        else :
            cnt.append(0)

    result.append(cnt)

for index, r in enumerate(result):
    print(f'#{index+1}')
    for c in r:
        print(f'{c} ', end='')
    print()