
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, T + 1):
    n = int(input())
    s = ''
    temp = []
    for _ in range(n) :
        l, n = list(input().split(' '))
        for _ in range(int(n)) :
            s += l

    length = len(s)
    cur = 0
    while cur < length :
        if length - cur > 10 :
            temp.append(s[cur:cur+10])
            cur += 10
        else :
            temp.append(s[cur:])
            break

    result.append(temp)


for idx, e in enumerate(result):
    print(f'#{idx+1}')
    for elm in e :
        print(elm)