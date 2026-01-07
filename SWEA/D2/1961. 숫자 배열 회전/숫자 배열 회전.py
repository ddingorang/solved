T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    def rotate(a):
        return [[a[n-1-j][i] for j in range(n)] for i in range(n)]

    r90 = rotate(matrix)
    r180 = rotate(r90)
    r270 = rotate(r180)

    print(f"#{test_case}")
    for i in range(n):
        print(
            ''.join(map(str, r90[i])),
            ''.join(map(str, r180[i])),
            ''.join(map(str, r270[i]))
        )