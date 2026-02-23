import sys
from itertools import combinations
from functools import reduce
from operator import mul


def solve():
    # 입력 받기
    n = int(sys.stdin.readline())
    trees = list(map(int, sys.stdin.readline().split()))

    # 1부터 N-1까지의 숫자 중 3개를 뽑는 조합 (구분선 위치)
    # 예: n=5일 때, 구역 사이 번호는 1, 2, 3, 4
    dividers_candidates = list(combinations(range(1, n), 3))

    max_sum = 0

    for div in dividers_candidates:
        # 선택된 구분선을 기준으로 리스트 슬라이싱
        # 예: div = (1, 2, 4) -> 인덱스 범위: [0:1], [1:2], [2:4], [4:n]
        indices = [0] + list(div) + [n]

        current_sum = 0
        for i in range(len(indices) - 1):
            start = indices[i]
            end = indices[i + 1]

            # 해당 구간의 곱 계산 (reduce와 mul 활용)
            group = trees[start:end]
            if group:
                current_sum += reduce(mul, group, 1)

        # 최대값 갱신
        if current_sum > max_sum:
            max_sum = current_sum

    print(max_sum)


if __name__ == "__main__":
    solve()