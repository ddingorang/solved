
T = int(input())
result = []

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    s = input()
    if s == s[::-1] : # 원래 단어와 뒤집은 단어가 같으면 회문임
        result.append(1)
    else :
        result.append(0)

for index, r in enumerate(result):
    print(f'#{index+1} {r}')