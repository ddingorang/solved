import sys

n = int(sys.stdin.readline().rstrip())
numlist = list(map(int, sys.stdin.readline().rstrip().split(' ')))
budget = int(sys.stdin.readline().rstrip())

numlist.sort()
avg = budget // len(numlist)
idx=0
if sum(numlist) < budget : print(max(numlist))
else :
    while numlist[idx] < avg:
        while numlist[idx] < avg:
            idx += 1
        avg = (budget - sum(numlist[:idx])) // (len(numlist)-idx)
        if numlist[idx] > avg : break
    print(avg)
