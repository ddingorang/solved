
def rotate(arr, direction):
    if direction == 1:  # 시계 방향
        # 마지막 원소를 맨 앞으로 보내기
        arr[:] = [arr[7]] + arr[:7]
    elif direction == -1:  # 반시계 방향
        # 첫 번째 원소를 맨 뒤로 보내기
        arr[:] = arr[1:] + [arr[0]]


t_str = input().strip()
if not t_str: exit()
t = int(t_str)
result = []

for tc in range(1, t + 1):
    k = int(input().strip())
    # 1번~4번 자석을 인덱스 1~4에 맞추기 위해 앞에 빈 리스트 추가
    magnets = [[]] + [list(map(int, input().split())) for _ in range(4)]

    for _ in range(k):
        mag_idx, direction = map(int, input().split())

        # 이번 회전 명령에서 각 자석이 돌 방향을 저장 (0으로 초기화)
        move_dir = [0] * 5
        move_dir[mag_idx] = direction

        # 1. 왼쪽 방향으로 전파 확인
        for i in range(mag_idx, 1, -1):
            if magnets[i][6] != magnets[i - 1][2]:
                move_dir[i - 1] = -move_dir[i]
            else:
                break  # 극이 같으면 전파 중단

        # 2. 오른쪽 방향으로 전파 확인
        for i in range(mag_idx, 4):
            if magnets[i][2] != magnets[i + 1][6]:
                move_dir[i + 1] = -move_dir[i]
            else:
                break  # 극이 같으면 전파 중단

        # 3. 결정된 방향대로 자석들 회전
        for i in range(1, 5):
            if move_dir[i] != 0:
                rotate(magnets[i], move_dir[i])

    # 점수 합계 계산
    scoresum = 0
    for i in range(1, 5):
        if magnets[i][0] == 1:  # S극인 경우 점수 획득
            scoresum += (2 ** (i - 1))

    result.append(scoresum)

for idx, e in enumerate(result):
    print(f"#{idx+1} {e}")