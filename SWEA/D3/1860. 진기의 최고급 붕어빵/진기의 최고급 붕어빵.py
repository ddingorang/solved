T = int(input())

for test_case in range(1, T + 1):
    n, m, k = map(int, input().split())  # n: 손님 수, m: 빵 만드는 주기, k: 한 번에 만드는 빵 개수
    ppl = sorted(map(int, input().split()))  # 손님 도착 시간 정렬

    possible = True
    for i, p in enumerate(ppl):
        bread_available = (p // m) * k  # 현재 시간까지 만들어진 빵 개수
        if bread_available < (i + 1):  # i+1은 지금까지 도착한 손님 수
            possible = False
            break

    print(f'#{test_case} {"Possible" if possible else "Impossible"}')
