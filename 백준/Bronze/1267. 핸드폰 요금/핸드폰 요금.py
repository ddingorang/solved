
import sys
# 1. 입력 받기
n = int(sys.stdin.readline())
times = list(map(int, sys.stdin.readline().split()))

y_total = 0
m_total = 0

# 2. 각 통화별 요금 계산
for t in times:
    y_total += (t // 30 + 1) * 10
    m_total += (t // 60 + 1) * 15

# 3. 결과 비교 및 출력
if y_total < m_total:
    print(f"Y {y_total}")
elif m_total < y_total:
    print(f"M {m_total}")
else:
    print(f"Y M {y_total}")