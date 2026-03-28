for t in range(1, int(input()) + 1):
    n = int(input())
    nums = list(map(int, input().split()))
    flag = True
    # 등차 수열 확인
    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                if nums[k] - nums[j] == nums[j] - nums[i]:
                    flag = False
                    break

    res = "YES" if flag else "NO"
    print(f"Case #{t}: {res}")