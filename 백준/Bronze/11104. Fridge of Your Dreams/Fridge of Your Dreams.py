
t = int(input())
result = []

for _ in range(t) :
    decimals = input().rstrip()
    temp = 0
    for i in range(24) :
        if decimals[i] == '1' :
            temp += 2**(23-i)
    result.append(temp)

for e in result:
    print(e)