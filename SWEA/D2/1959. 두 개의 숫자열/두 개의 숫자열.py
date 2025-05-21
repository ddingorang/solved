
T = int(input())
result = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b = list(map(int, input('').split(' ')))
    la = list(map(int, input('').split(' ')))
    lb = list(map(int, input('').split(' ')))

    maxsum = 0
    if a >= b:
        for inc in range(a-b+1) :
            tempsum = 0
            for i in range(b) :
                tempsum += la[i+inc] * lb[i]
            if maxsum < tempsum :
                maxsum = tempsum

    elif a < b :
        for inc2 in range(b-a+1) :
            tempsum2 = 0
            for j in range(a) :
                tempsum2 += la[j] * lb[j+inc2]
            if maxsum < tempsum2 :
                maxsum = tempsum2

    result.append(maxsum)



for index, r in enumerate(result):
    print(f'#{index+1} {r}')