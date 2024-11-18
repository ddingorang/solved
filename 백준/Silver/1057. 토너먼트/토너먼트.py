import sys

n, a, b = map(int, sys.stdin.readline().rstrip().split(' '))

count = 0
while 1:
    count += 1
    a = (a+1) // 2
    b = (b+1) // 2
    if a == b:
        break

print(count)