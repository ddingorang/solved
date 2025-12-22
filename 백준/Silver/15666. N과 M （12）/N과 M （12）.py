from itertools import combinations_with_replacement

n, m = map(int, input().split())
nums = sorted(set(map(int, input().split())))

for comb in combinations_with_replacement(nums, m):
    print(*comb)