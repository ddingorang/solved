import sys

def solve():
    # 입력 받기
    try:
        line = sys.stdin.readline()
        if not line:
            return
        n = int(line.strip())
    except ValueError:
        return

    # 1. n이 0인 경우 (문제 조건: 1비트 사용)
    if n == 0:
        print(1)
    
    # 2. n이 음수인 경우
    # 32비트 2의 보수 체계에서 음수는 최상위 비트(MSB)가 1이므로 
    # 앞에 연속된 0이 나올 수 없습니다. 따라서 항상 32비트입니다.
    elif n < 0:
        print(32)
    
    # 3. n이 양수인 경우
    # 0을 제외한 가장 왼쪽의 1부터 개수를 셉니다.
    else:
        # bin(10) -> '0b1010' 이므로 앞의 '0b'를 제외한 길이를 출력
        print(len(bin(n)) - 2)

solve()