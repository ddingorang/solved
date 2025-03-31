
result = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 10 + 1):
    T = int(input())
    n, m = map(int, input().split())
    result.append(n**m)

for idx, val in enumerate(result):
    print(f'#{idx+1} {val}')
