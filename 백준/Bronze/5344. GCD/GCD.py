import sys

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

# sys.stdin.read().split()을 쓰면 모든 입력을 한꺼번에 가져와서 
# 공백이나 줄바꿈 상관없이 숫자만 순서대로 꺼내 쓸 수 있어 안전합니다.
input_data = sys.stdin.read().split()

if input_data:
    n = int(input_data[0])
    idx = 1
    for _ in range(n):
        a = int(input_data[idx])
        b = int(input_data[idx + 1])
        print(gcd(a, b))
        idx += 2