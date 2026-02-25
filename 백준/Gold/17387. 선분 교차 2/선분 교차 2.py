import sys

def ccw(x1, y1, x2, y2, x3, y3):
    val = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)
    if val > 0: return 1
    if val < 0: return -1
    return 0

# 입력 받기
x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
x3, y3, x4, y4 = map(int, sys.stdin.readline().split())

# CCW 판정
abc = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)
cda = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)

if abc <= 0 and cda <= 0:
    if abc == 0 and cda == 0: # 네 점이 일직선인 경우
        # x축과 y축 모두에서 선분이 겹치는지 개별 확인
        if min(x1, x2) <= max(x3, x4) and min(x3, x4) <= max(x1, x2) and \
           min(y1, y2) <= max(y3, y4) and min(y3, y4) <= max(y1, y2):
            print(1)
        else:
            print(0)
    else: # 일반적인 교차 상황 (끝점이 닿는 경우 포함)
        print(1)
else:
    print(0)