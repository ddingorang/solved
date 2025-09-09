from collections import defaultdict
import sys

result = []

n, m = tuple(map(int, sys.stdin.readline().rstrip().split(' ')))
sites = defaultdict(str)
for _ in range(n) :
    site, pwd = sys.stdin.readline().rstrip().split(' ')
    sites[site] = pwd

for _ in range(m) :
    search = sys.stdin.readline().rstrip()
    result.append(sites[search])

for e in result:
    print(e)