import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))

p = [0] * (n+1)
for i in range(n+1) :
    p[i] = i

def find(a) :
    if a == p[a] :
        return a
    else :
        p[a] = find(p[a])
        return p[a]

def union(a, b) :
    a = find(a)
    b = find(b)
    if a != b :
        p[b] = a

def isSame(a, b) :
    a = find(a)
    b = find(b)
    if a==b :
        return True
    return False

result = []
for _ in range(m) :
    x, a, b = map(int, sys.stdin.readline().rstrip().split(' '))
    if x == 0 :
        union(a, b)
    elif x == 1:
        if isSame(a, b) :
            result.append('YES')
        else :
            result.append('NO')

for e in result:
    print(e)



