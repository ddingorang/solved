
T = int(input())
result = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    l = list(map(int, input().split(' ')))
    temp = []
    for e in l :
        inc = 1
        line = 0 # 몇 번째 라인인지
        cur = 0
        while cur < e :
            cur += inc
            inc += 1
            line += 1
        defx, defy = line, 1
        diff = cur - e
        x, y = defx - diff, defy + diff
        temp.append((x, y))

    tempx, tempy = 0, 0
    for t in temp :
        tempx += t[0]
        tempy += t[1]

    whichline = tempx + tempy - 1
    defx2, defy2 = whichline, 1
    diff = whichline - tempx
    tempsum = 0
    for inc2 in range(1, whichline+1) :
        tempsum += inc2

    result.append(tempsum - diff)

for index, r in enumerate(result):
    print(f'#{index+1} {r}')