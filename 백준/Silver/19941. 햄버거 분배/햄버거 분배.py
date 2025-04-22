n, k = map(int, input().split(' '))
table = list(input())

count = 0
for i in range(len(table)) :
    if table[i] == 'P' :
        # 앞 뒤 k개까지 햄버거 확인
        for j in range(i-k, i+k+1) :
            if j >= 0 and j < len(table) :
                if table[j] == 'H' :
                    # 최대한 앞쪽에 있는 것을 먹어야 그리디
                    # X로 분배 처리
                    table[j] = 'X'
                    count += 1
                    break

print(count)