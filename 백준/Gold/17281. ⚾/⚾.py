import sys
from itertools import permutations

# 빠른 입력을 위해 sys.stdin.readline 사용
input = sys.stdin.readline

n = int(input())
innings = [list(map(int, input().split())) for _ in range(n)]

max_score = 0

# 1번 선수는 이미 4번 타자(인덱스 3)로 고정되어 있으므로, 
# 나머지 2~9번 선수(인덱스 1~8)의 순열만 구합니다.
for p in permutations(range(1, 9)):
    p = list(p)
    # 타순 생성: 1~3번 타자 + 4번 타자(0번 선수) + 5~9번 타자
    lineup = p[:3] + [0] + p[3:]

    score = 0
    cur_batter_idx = 0  # 현재 타자의 라인업 내 인덱스 (0~8)

    for inning in innings:
        out_count = 0
        # 베이스 상황을 변수나 리스트로 관리 (b1, b2, b3)
        b1, b2, b3 = 0, 0, 0

        while out_count < 3:
            res = inning[lineup[cur_batter_idx]]

            if res == 0:  # 아웃
                out_count += 1
            elif res == 1:  # 안타
                score += b3
                b1, b2, b3 = 1, b1, b2
            elif res == 2:  # 2루타
                score += (b2 + b3)
                b1, b2, b3 = 0, 1, b1
            elif res == 3:  # 3루타
                score += (b1 + b2 + b3)
                b1, b2, b3 = 0, 0, 1
            elif res == 4:  # 홈런
                score += (b1 + b2 + b3 + 1)
                b1, b2, b3 = 0, 0, 0

            # 다음 타자로 이동 (9번 타자 다음은 다시 1번 타자)
            cur_batter_idx = (cur_batter_idx + 1) % 9

    if score > max_score:
        max_score = score

print(max_score)