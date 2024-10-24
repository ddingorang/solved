import sys

t = int(sys.stdin.readline().rstrip())
result = []
for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    book1 = list(map(int, sys.stdin.readline().rstrip().split()))
    m = int(sys.stdin.readline().rstrip())
    book2 = list(map(int, sys.stdin.readline().rstrip().split()))

    book1.sort() # 이진 탐색 위해 오름차순 정렬

    for e in book2:
        start = 0 # 시작
        end = len(book1) - 1 # 끝

        while start <= end: # 시작이 끝과 같아지거나 앞질렀을 때 탐색 종료
            mid = (start + end) // 2
            if book1[mid] > e:
                end = mid - 1
            elif book1[mid] < e:
                start = mid + 1
            else: # 탐색 성공
                result.append(1)
                break
        else: # 탐색 실패
            result.append(0)

for r in result:
    print(r)
