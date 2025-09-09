from collections import Counter
import sys

n = int(sys.stdin.readline().rstrip())
num = []
for i in range(n):
    num.append(int(sys.stdin.readline().rstrip()))

num.sort()
cnt = Counter(num)
sub = [i for i, j in cnt.items() if max(cnt.values()) == j]

a = round(sum(num) / n)
b = num[n // 2]
if len(sub) == 1:
    c = sub[0]
else:
    c = sub[1]
d = num[-1] - num[0]

print(a, b, c, d, sep='\n')