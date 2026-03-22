import sys

# 빠른 입력을 위해 사용
input = sys.stdin.readline

def solve():
    try:
        line = input().split()
        if not line: return
        T = int(line[0])
        
        for i in range(1, T + 1):
            # M: 달 수, D: 한 달 일수, W: 한 주 일수
            M, D, W = map(int, input().split())
            
            total_rows = 0
            current_start_day = 0 # 0(첫 번째 요일)부터 시작
            
            for _ in range(M):
                # 해당 달이 차지하는 칸 수 = 시작 공백 + 날짜 수
                cells_needed = current_start_day + D
                
                # 필요한 줄 수 계산 (올림)
                rows_for_this_month = (cells_needed + W - 1) // W
                total_rows += rows_for_this_month
                
                # 다음 달이 시작될 요일 계산
                current_start_day = cells_needed % W
                
            print(f"Case #{i}: {total_rows}")
            
    except EOFError:
        pass

if __name__ == "__main__":
    solve()