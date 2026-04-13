

t = int(input())
result = []
for _ in range(t):
    j, n = map(int, input().split(' '))
    l = []
    for _ in range(n):
        r, c = map(int, input().split(' '))
        l.append(r*c)

    l.sort(reverse=True)
    boxcnt = 0
    for box in l:
        if j<=0 : break
        j -= box
        boxcnt += 1

    result.append(boxcnt)

for e in result:
    print(e)