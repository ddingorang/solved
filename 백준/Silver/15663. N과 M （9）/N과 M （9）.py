from itertools import permutations
n, m = tuple(map(int, input().split(' ')))
l = list(map(int, input().split(' ')))

lst = list(set(permutations(l, m)))
lst = sorted(lst)

for e in lst:
    for idx in range(len(e)):
        print(e[idx], end=' ')
    print()