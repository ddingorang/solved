
result = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 10 + 1):
    T = int(input())
    board = []
    sums = []
    for _ in range(100) :
        board.append(list(map(int, input().split())))

    for i in range(0, 100) :
        sums.append(sum(board[i]))

    for j in range(0, 100) :
        temp = 0
        for k in range(0, 100) :
            temp += board[k][j]
        sums.append(temp)

    temp2 = 0
    for x in range(0, 100):
        temp2 += board[x][x]
    sums.append(temp2)

    temp3 = 0
    for y in range(0, 100):
        temp3 += board[y][99 - y]
    sums.append(temp3)

    result.append(max(sums))


for idx, val in enumerate(result):
    print(f'#{idx+1} {val}')
