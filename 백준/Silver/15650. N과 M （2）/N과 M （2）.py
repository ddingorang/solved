from itertools import combinations
n, m = tuple(map(int, input().split(' ')))

lst = list(combinations(range(1, n+1), m))

for e in lst:
    for idx in range(len(e)):
        print(e[idx], end=' ')
    print()