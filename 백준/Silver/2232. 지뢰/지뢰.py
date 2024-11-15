import sys

n = int(sys.stdin.readline().rstrip())
lst = []
for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    lst.append(x)

result = []
for i in range(len(lst)):
    l = lst[i - 1] if i > 0 else -float('inf')  # 첫 번째 요소는 왼쪽이 없으므로 -inf로 처리
    r = lst[i + 1] if i < len(lst) - 1 else -float('inf')  # 마지막 요소는 오른쪽이 없으므로 -inf로 처리

    # 현재 값이 양 옆 값보다 크거나 같으면 result에 추가
    if lst[i] >= l and lst[i] >= r:
        result.append(i + 1)

# 결과 출력
for e in result:
    print(e)
