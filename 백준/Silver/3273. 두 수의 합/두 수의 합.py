import sys

n = int(sys.stdin.readline().rstrip())
numlist = list(map(int, sys.stdin.readline().rstrip().split(' ')))
x = int(sys.stdin.readline().rstrip())

numlist.sort() # 오름차순으로 정렬
count = 0 # 만족하는 쌍의 수
l = 0 # 왼쪽 포인터
r = n-1 # 오른쪽 포인터
for _ in range(n) :
    if l == r or l > r : break # 두 포인터가 같아지거나 교차한다면 그만
    elif numlist[l] + numlist[r] > x : # 두 합이 x보다 크면 오른쪽 포인터를 왼쪽으로 이동
        r -= 1
    elif numlist[l] + numlist[r] < x : # 두 합이 x보다 작으면 왼쪽 포인터를 오른쪽으로 이동
        l += 1
    elif numlist[l] + numlist[r] == x : # 두 합이 x과 같으면 카운트 추가
        count += 1
        r -= 1 # 두 포인터 모두 이동
        l += 1

print(count)