import sys

n = int(sys.stdin.readline().rstrip())
cnt = [0 for _ in range(10001)]
for i in range(n) :
    num = int(sys.stdin.readline().rstrip())
    cnt[num] += 1

for j in range(1, 10001) :
    if cnt[j] != 0 :
        for _ in range(cnt[j]) :
            print(j)