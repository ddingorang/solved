
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, 10 + 1):
    n = int(input())
    s = list(input().split(' ')[:-1])
    cn = int(input())
    c = list(input().split('I '))
    for i in range(1, len(c)) :
        cmd = tuple(c[i].split(' ')[:-1])
        pos = cmd[0]
        num = cmd[1]
        for j in range(2, len(cmd)):

            s.insert(int(pos)+j-2, cmd[j])

    result.append(s)


for idx, e in enumerate(result):
    print(f'#{idx+1} ', end='')
    for ix, elm in enumerate(e) :
        if ix == 10 :
            break
        print(f'{elm} ', end='')
    print()

