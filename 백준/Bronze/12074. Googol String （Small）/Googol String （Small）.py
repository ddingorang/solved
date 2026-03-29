import sys

def solve():
    # 표준 입력으로부터 T(테스트 케이스 수)를 읽음
    try:
        line = sys.stdin.readline()
        if not line:
            return
        t = int(line.strip())
    except ValueError:
        return

    for i in range(1, t + 1):
        try:
            k = int(sys.stdin.readline().strip())
        except ValueError:
            break
            
        ans = get_kth_char(k)
        print(f"Case #{i}: {ans}")

def get_kth_char(k):
    flip_count = 0
    
    while True:
        # k가 2의 거듭제곱인지 확인 (가운데 "0" 자리에 해당하는지)
        # k & (k - 1) == 0 이면 k는 2의 거듭제곱입니다.
        if (k & (k - 1)) == 0:
            # 중간값은 항상 "0"이므로, 지금까지 바뀐 횟수(flip_count)에 따라 결정
            return 0 if flip_count % 2 == 0 else 1
        
        # k보다 큰 가장 작은 2의 거듭제곱(현재 문자열의 길이+1) 찾기
        # 예: k=6이면 m=8
        m = 1 << k.bit_length()
        
        # 대칭 위치(mirror)로 k를 이동: k_new = m - k
        # reverse(SN-1) 구조 때문에 대칭점으로 이동합니다.
        k = m - k
        flip_count += 1

if __name__ == "__main__":
    solve()