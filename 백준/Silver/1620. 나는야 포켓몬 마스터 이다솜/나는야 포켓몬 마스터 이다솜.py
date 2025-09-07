from collections import defaultdict

result = []
n, m = tuple(map(int, input('').split(' ')))
pokemons = defaultdict(int)
idx = defaultdict(str)
for i in range(n):
    name = input('')
    pokemons[name] = i+1
    idx[i+1] = name

for j in range(m):
    q = input('')
    if q.isdigit():
        result.append(idx[int(q)])
    else :
        result.append(pokemons[q])

for e in result:
    print(e)