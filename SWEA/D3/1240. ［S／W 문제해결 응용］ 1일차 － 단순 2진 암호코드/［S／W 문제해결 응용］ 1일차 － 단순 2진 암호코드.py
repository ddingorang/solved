
T = int(input())
result = []
codes = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111',
         '0111011', '0110111', '0001011']
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    r, c = list(map(int, input('').split(' ')))
    s = []
    for k in range(r) :
        s.append(input())

    pattern = ''
    for x in range(r-1, -1, -1) :
        row = s[x]
        for i in range(c-1, -1, -1) :
            # 끝에서부터 체크해야.. 왜냐하면 모든 암호 패턴은 맨 끝이 1임
            # 맨 앞은 0이거나 1일 수 있기 때문
            if s[x][i] == '1' :
                pattern = row[i-55:i+1] # 패턴의 길이는 56
                break

    spp = []
    # 7자씩 끊기
    for j in range(8) :
        spp.append(pattern[j*7:j*7+7])

    # 해독
    decoded = []
    for e in spp:
        decoded.append(codes.index(e))

    # 유효성 검사
    validate = 0
    for idx, d in enumerate(decoded) :
        if (idx+1) % 2 == 0 :
            validate += d
        else :
            validate += d*3

    if validate % 10 == 0: # 유효 코드
        result.append(sum(decoded))
    else :
        result.append(0)


for index, r in enumerate(result):
    print(f'#{index+1} {r}')