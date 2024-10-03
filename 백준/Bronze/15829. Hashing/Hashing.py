import sys

a = int(sys.stdin.readline().rstrip())
s = sys.stdin.readline().rstrip()
h = 0 # 해쉬 값 저장
for i in range(a) :
    h += (ord(s[i])-96)*(31**i)

print(h % 1234567891)