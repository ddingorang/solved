from itertools import permutations
n, m = tuple(map(int, input().split(' ')))
l = list(map(int, input().split(' ')))
sl = sorted(l)

lst = list(permutations(sl, m))

for e in lst:
    for idx in range(len(e)):
        print(e[idx], end=' ')
    print()