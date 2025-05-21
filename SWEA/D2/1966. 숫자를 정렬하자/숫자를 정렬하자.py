T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, T + 1):
    n = int(input())
    numlist = list(map(int, input().split(' ')))
    numlist.sort()
    result.append(numlist)

for idx, e in enumerate(result):
    print(f'#{idx+1} ', end='')
    for elm in e:
        print(f'{elm} ', end='')
    print()