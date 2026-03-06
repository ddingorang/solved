t = int(input())

for _ in range(t):
    _ = int(input()) # 배열의 길이 (파이썬에서는 보통 사용하지 않음)
    l = list(map(int, input().split()))

    # 배열의 첫 번째 요소를 초기값으로 설정하여 예외 차단
    max_val = l[0]
    min_val = l[0]

    for e in l:
        if e > max_val: 
            max_val = e
        if e < min_val: 
            min_val = e

    print(min_val, max_val)