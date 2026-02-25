n = int(input())
xl = []
yl = []

for _ in range(n):
    x, y = map(int, input().split(' '))
    xl.append(x)
    yl.append(y)

tmp1 = 0
for i in range(n) :
    tmp1 += (xl[i] * yl[(i+1) % n])

tmp2 = 0
for i in range(n) :
    tmp2 += (yl[i] * xl[(i+1)% n] )

area = abs(tmp1 - tmp2) * 0.5

print(area)