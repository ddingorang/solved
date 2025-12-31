T = int(input())
result = []
for test_case in range(1, T + 1):
    n, m = tuple(map(int, input().split(' ')))
    nl = list(map(int, input().split(' ')))
    ml = list(map(int, input().split(' ')))

    maxsum = []
    if n <= m:
        for k in range(m-n+1) :
            summ = 0
            for i in range(n) :
                summ += (nl[i] * ml[i+k])
            maxsum.append(summ)
    else :
        for k in range(n-m+1) :
            summ = 0
            for i in range(m) :
                summ += (nl[i+k] * ml[i])
            maxsum.append(summ)

    result.append(max(maxsum))

for idx, e in enumerate(result):
    print(f'#{idx+1} {e}')