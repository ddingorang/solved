from decimal import Decimal, ROUND_HALF_UP
import sys

# 1. 입력 받기
t_str = sys.stdin.readline().strip()
if not t_str:
    exit()
t = int(t_str)

for _ in range(t):
    line = sys.stdin.readline().split()
    if not line:
        continue
        
    amt, unit = line[0], line[1]
    
    # float 대신 Decimal 객체로 생성 (반드시 '문자열' 형태로 전달해야 오차가 없음)
    val = Decimal(amt)
    res_val = Decimal('0')
    res_unit = ''

    # 2. 단위 변환 로직 (상수값도 Decimal로 정의)
    if unit == 'kg':
        res_val = val * Decimal('2.2046')
        res_unit = 'lb'
    elif unit == 'lb':
        res_val = val * Decimal('0.4536')
        res_unit = 'kg'
    elif unit == 'l':
        res_val = val * Decimal('0.2642')
        res_unit = 'g'
    elif unit == 'g':
        res_val = val * Decimal('3.7854')
        res_unit = 'l'

    # 3. 사사오입 적용 (소수점 4째 자리까지)
    # '0.0001' 형식으로 지정하고 ROUND_HALF_UP 옵션을 사용함
    output = res_val.quantize(Decimal('0.0000'), rounding=ROUND_HALF_UP)
    
    print(f"{output} {res_unit}")