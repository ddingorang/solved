n = int(input())
nums = list(map(int, input().split()))

# 일단 양쪽 끝 폭죽을 하나씩 줄이고 시작한다
# 맨 마지막(3개가 남았을 때)에는 양쪽 둘 다 하나씩 줄어들 것이기 때문
nums[0] -= 1
nums[n-1] -= 1

# 그러면 폭죽을 터트릴 기회는 (n-3)회
count = n-3
for _ in range(n-3):
    # 양쪽 폭죽 가운데 무엇을 터트릴 지는 상관없다
    # 중요한 것은 양쪽 끝 폭죽의 높이

    # 더 크거나 같은 쪽을 줄임
    if nums[0] >= nums[n-1]:
        nums[0] -= 1
    else :
        nums[n-1] -= 1

print(max(nums[0], nums[n-1]))