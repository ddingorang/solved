import math
h, w, n, m = map(int, input().split(' '))

colnum = math.ceil(h/(n+1))
rownum = math.ceil(w/(m+1))

print(colnum * rownum)