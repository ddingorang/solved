import sys

result = []
while 1:
    a = sys.stdin.readline().rstrip()
    ispldrm = 0
    if a == '0' : break
    if len(a) == 1 :
        result.append('yes')
        continue
    for i in range(int(len(a)//2)) :
        if a[i] == a[len(a)-1-i] : ispldrm = 1
        else :
            ispldrm = 0
            break
    if ispldrm == 1 : result.append('yes')
    else : result.append('no')

for e in result :
    print(e)