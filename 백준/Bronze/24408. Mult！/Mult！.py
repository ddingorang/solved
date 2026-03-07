
n = int(input())

isFirst = False
firstnum = -1
for _ in range(n):
    if not isFirst :
        firstnum = int(input())
        isFirst = True
    else :
        cur = int(input())
        if cur % firstnum == 0 :
            print(cur)
            isFirst = False
