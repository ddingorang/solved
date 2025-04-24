def solution(n):
    nums = []
    while n != 0 :
        nums.append(n % 3)
        n = n // 3
    
    acc = 0
    for i in range(len(nums)-1, -1, -1) :
        acc += nums[len(nums)-1-i] * (3 ** i)
    answer = acc
    return answer