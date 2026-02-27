n = int(input())
result = []
for _ in range(n):
    num = int(input())
    matsal = []

    for _ in range(num):
        matsal.append(tuple(map(int, input().split(' '))))

    matsal = sorted(matsal, key = lambda x : x[1])

    min = float('inf')
    minvalue = float('inf')
    maxidx = -1
    for idx, m in enumerate(matsal):
       if float(m[1]) / float(m[0]) < min:
           min = float(m[1]) / float(m[0])
           maxidx = idx

    result.append(matsal[maxidx][1])

for e in result:
    print(e)
