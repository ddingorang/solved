
n = int(input())
count = 0
while True:
    if n == 1:
        break
    if n % 2 == 1: # odd
        n *= 3
        n += 1
        count += 1
    else : # even
        n /= 2
        count += 1

print(count)
