import sys
n = int(sys.stdin.readline().rstrip())

chong = ["ChongChong"]
for _ in range(n):
    [x, y] = map(str, input().strip().split())
    if x in chong:
        chong.append(y)
    elif y in chong:
        chong.append(x)
    else: continue

result = list(set(chong))

print(len(result))