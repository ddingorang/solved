
T = int(input())
result = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    i = int(input())
    numbers = set()
    mul = 1
    cnt = 0
    while True:
        num = i * mul
        strnum = str(num)
        for s in range(len(strnum)) :
            numbers.add(strnum[s])
        if len(numbers) == 10:
            cnt += 1
            break
        else :
            cnt += 1
            mul += 1

    result.append(cnt*i)


for index, r in enumerate(result):
    print(f'#{index+1} {r}')