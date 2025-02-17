n = int(input())
result = []

for _ in range(n):
    testcase = list(map(int, input().split(' ')))
    testcase = testcase[1:]
    shiftcnt = 0
    for i in range(1, 20) :
        forward = list(testcase)[:i]
        for j in range(len(forward)) :
            if forward[j] > testcase[i] :
                val = testcase[i]
                testcase.remove(val)
                testcase.insert(j, val)
                shiftcnt += (i-j)
                break

    result.append(shiftcnt)

for idx, e in enumerate(result):
    print(f'{idx+1} {e}')