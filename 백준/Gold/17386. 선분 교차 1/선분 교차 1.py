
x1, y1, x2, y2 = map(int, input().split(' '))
x3, y3, x4, y4 = map(int, input().split(' '))
cross = False
# CCW(Counter-ClockWise)
# CCW(A, B, C) = (x1y2 + x2y3 + x3y1) - (y1x2 + y2x3 + y3x1)
# L1((x1, y1) - (x2, y2))을 기준으로 (x3, y3)와 (x4, y4)가 서로 반대에 있어야 함
# CCW(A, B, C) * CCW(A, B, D) < 0
if ((x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1)) * ((x1*y2 + x2*y4 + x4*y1) - (y1*x2 + y2*x4 + y4*x1)) < 0:
    # L2((x3, y3) - (x4, y4))을 기준으로 (x1, y1)와 (x2, y2)가 서로 반대에 있어야 함
    # CCW(C, D, A) * CCW(C, D, B) < 0
    if((x3*y4 + x4*y1 + x1*y3) - (y3*x4 + y4*x1 + y1*x3)) * ((x3*y4 + x4*y2 + x2*y3) - (y3*x4 + y4*x2 + y2*x3)) < 0:
        cross = True

if cross :
    print(1)
else :
    print(0)

