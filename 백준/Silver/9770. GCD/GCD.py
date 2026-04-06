import sys
import math

nums = []

# 입력 전체 읽기
for line in sys.stdin:
    nums.extend(map(int, line.split()))

max_gcd = 0

# 모든 쌍 비교
for i in range(len(nums)):
    for j in range(i + 1, len(nums)):
        g = math.gcd(nums[i], nums[j])
        if g > max_gcd:
            max_gcd = g

print(max_gcd)