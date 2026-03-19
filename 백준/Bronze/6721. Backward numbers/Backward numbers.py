
n = int(input())

for _ in range(n):
    a, b = input().split(' ')
    reva = int(a[::-1])
    revb = int(b[::-1])

    summ = reva + revb
    
    rsumm = str(summ)[::-1]
    print(int(rsumm))