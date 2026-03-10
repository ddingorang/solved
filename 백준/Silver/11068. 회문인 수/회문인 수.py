import sys

def is_palindrome(n, b):
    """숫자 n을 b진법으로 변환했을 때 회문인지 판별하는 함수"""
    converted = []
    temp = n
    
    # 진법 변환 (각 자릿수를 리스트에 저장)
    while temp > 0:
        converted.append(temp % b)
        temp //= b
        
    # 회문 검사 (리스트를 뒤집은 것과 원래 리스트가 같은지 확인)
    return converted == converted[::-1]

def solve():
    # 입력 속도 향상을 위한 처리
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    t = int(input_data[0]) # 테스트 케이스 개수
    numbers = map(int, input_data[1:])
    
    for n in numbers:
        found = False
        # 2진법부터 64진법까지 순회
        for base in range(2, 65):
            if is_palindrome(n, base):
                found = True
                break
        
        # 하나라도 회문이면 1, 아니면 0 출력
        print(1 if found else 0)

if __name__ == "__main__":
    solve()