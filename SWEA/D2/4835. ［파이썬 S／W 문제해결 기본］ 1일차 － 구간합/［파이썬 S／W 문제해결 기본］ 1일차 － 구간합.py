T = int(input())
result = []

for test_case in range(1, T + 1):
    n, m = list(map(int, input().split()))
    numlist = list(map(int, input().split()))

    minsum = float('inf')
    maxsum = 0
    for j in range(n - m + 1):
        temp = sum(numlist[j:j + m])
        if minsum > temp:
            minsum = temp
        if maxsum < temp:
            maxsum = temp

    result.append(maxsum - minsum)

for index, r in enumerate(result):
    print(f'#{index + 1} {r}')
