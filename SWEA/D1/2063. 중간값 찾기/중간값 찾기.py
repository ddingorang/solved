n = int(input(''))

numlist = list(map(int, input().split(' ')))
numlist.sort()
print(numlist[len(numlist)//2])