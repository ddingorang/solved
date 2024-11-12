import sys
import math

n = int(sys.stdin.readline().rstrip())

l = [0]*10000001
for i in range(2, 10000001) :
    l[i] = i

for j in range(2, int(math.sqrt(len(l)) + 1)) : # 에라토스테네스의 체
    if l[j] == 0: continue
    for k in range(2*j, len(l), j) :
        l[k] = 0 # 소수가 아닌 것은 제거

def isPalindrome(x):
    str_x = str(x)
    start = 0
    end = len(str_x) - 1
    while start <= end:
        if str_x[start] != str_x[end] : return False
        start += 1
        end -= 1
    return True

cur = n
while cur < len(l):
    if int(l[cur]) == 0 :
        cur += 1
        continue
    elif isPalindrome(int(l[cur])) == True:
        print(cur)
        break
    else:
        cur += 1