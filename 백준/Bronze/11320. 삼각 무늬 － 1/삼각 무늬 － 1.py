
n = int(input())
result = []
for _ in range(n):
    a, b = map(int, input().split(' '))

    result.append(int((a**2) / (b ** 2)))

for e in result:
    print(e)