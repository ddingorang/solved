
T = int(input())
result = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    temp = 0
    for i in range(1, n+1) :
        if i % 2 == 1 :
            temp += i
        else :
            temp -= i
    result.append(temp)


for index, r in enumerate(result):
    print(f'#{index+1} {r}')