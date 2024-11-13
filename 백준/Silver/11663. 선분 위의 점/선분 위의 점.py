import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
p = list(map(int, sys.stdin.readline().rstrip().split(' ')))
result = []
p.sort()

for _ in range(m) :
    a, b = map(int, sys.stdin.readline().rstrip().split(' '))

    # 최소 인덱스
    f = 0
    r = len(p)-1
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if p[mid] < a:
            start = mid + 1
        else:
            end = mid - 1
    one = end + 1

    # 최대 인덱스
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if b < p[mid]:
            end = mid - 1
        else:
            start = mid + 1
    two = end

    result.append(two-one+1) # 그 사이의 갯수

for e in result :
    print(e)

