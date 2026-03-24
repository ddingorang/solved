import sys

def solve():
    # 입력 받기
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))

    # (값, 원래 인덱스) 형태의 리스트 생성
    # 예: a = [2, 3, 1] -> b = [(2, 0), (3, 1), (1, 2)]
    b = []
    for i in range(n):
        b.append((a[i], i))

    # 값을 기준으로 오름차순 정렬
    # Python의 sort는 stable하므로 값이 같으면 인덱스 순서가 유지됨
    b.sort(key=lambda x: x[0])

    # 정렬된 위치를 담을 결과 배열 P
    p = [0] * n

    # 정렬된 리스트 b를 순회하며 
    # 원래 인덱스(original_idx) 위치에 현재 순서(i)를 기록
    for i in range(n):
        original_idx = b[i][1]
        p[original_idx] = i

    # 결과 출력
    print(*(p))

if __name__ == "__main__":
    solve()