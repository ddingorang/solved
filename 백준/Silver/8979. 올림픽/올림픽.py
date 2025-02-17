n, m = map(int, input().split(' '))
olympic = []
target = []
for _ in range(n) :
    total = list(map(int, input().split(' ')))
    if total[0] == m :
        target = total[1:]
    olympic.append(total)

olympic.sort(key=lambda x: (-x[1], -x[2], -x[3]))
# 첫 번째로 금메달 순, 두 번째로 은메달 순

medals = [rows[1:] for rows in olympic] # 첫 인덱스 제외하고 메달 현황만 슬라이싱
where = medals.index(target) # 메달 현황이 같다면 맨 앞에 있는 원소의 인덱스가 순위임
print(where + 1)

