
n, m = tuple(map(int, input().split(' ')))
course = list(map(int, input().split(' ')))

# 최대 크기는 모든 강의 합친 길이
# 최소 크기는 강의 중 최대 길이의 강의 크기
# 최대, 최소 사이를 이분 탐색
# 중간값 = (최대 + 최소) / 2

start = max(course)
end = sum(course)
while start <= end:
    mid = (start + end) // 2
    sum = 0
    count = 0
    for i in range(n):
        if sum + course[i] > mid :
            count += 1
            sum = 0
        sum += course[i]

    # 다 돌고 나서 합이 0이라면
    # 아직 블루레이에 담기지 않은 영상이 있는 것이므로
    # 블루레이 하나 더 써서 담아야 함
    if sum != 0:
        count += 1

    # 만들어야 하는 블루레이 개수보다 많으면 : 개수를 줄여야 한다
    # 그러면 블루레이의 크기를 늘려야
    if count > m :
        start = mid + 1

    # 많지 않으면 : 블루레이의 크기를 줄여본다
    else:
        end = mid - 1

print(start)