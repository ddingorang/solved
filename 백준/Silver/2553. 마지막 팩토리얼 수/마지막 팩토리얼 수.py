import sys

n = int(sys.stdin.readline().rstrip())
mul = 1
for i in range(1, n+1):
    mul *= i # 1부터 곱하기 시작
    while mul % 10 == 0 : # 끝에 0이 생길 때 마다 10으로 나누어 줌
        mul /= 10 # 끝의 0을 없애는 효과
    mul %= 1000000 # 너무 커지지 않게하는 안전장치
print(int(mul%10))