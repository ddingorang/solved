import sys

# 입력 속도를 위해 sys.stdin.read 사용 가능
n = int(sys.stdin.readline())
tanghuru = list(map(int, sys.stdin.readline().split()))

count_dict = {}  # 각 과일의 개수를 저장
left = 0
max_len = 0
kind = 0  # 현재 과일 종류의 수

for right in range(n):
    # 오른쪽 과일 추가
    fruit = tanghuru[right]
    if fruit not in count_dict or count_dict[fruit] == 0:
        kind += 1
        count_dict[fruit] = 1
    else:
        count_dict[fruit] += 1

    # 과일 종류가 2개를 초과하면 왼쪽에서 제거
    while kind > 2:
        left_fruit = tanghuru[left]
        count_dict[left_fruit] -= 1
        if count_dict[left_fruit] == 0:
            kind -= 1
        left += 1

    # 현재 유효한 구간의 길이 계산
    max_len = max(max_len, right - left + 1)

print(max_len)