from itertools import combinations
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
T = int(input())
for test_case in range(1, T + 1):
   numlist = list(map(int, input().split(' ')))
   comb = list(combinations(numlist, 3))
   combsum = set()
   for c in comb :
       combsum.add(sum(c))
   lc = list(combsum)
   lc.sort(reverse=True)
   result.append(lc[4])


for idx, e in enumerate(result):
    print(f'#{idx+1} {e}')

