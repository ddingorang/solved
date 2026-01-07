T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
result = []
for test_case in range(1, T + 1):
    n = int(input(''))
    numberofeight = n // 2
    if n == 1:
        result.append('0')
    elif n % 2 == 0 : # 짝수
        temp = '8' * numberofeight
        result.append(temp)
    else :
        temp = '4'
        temp += ('8'*numberofeight)
        result.append(temp)

for e in result:
    print(e)
