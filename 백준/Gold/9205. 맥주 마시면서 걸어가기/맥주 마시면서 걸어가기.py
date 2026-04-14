from collections import deque, defaultdict

t = int(input())

for _ in range(t):
    succeed = False
    n = int(input())
    v = [False for _ in range(n)]
    l = []

    start = tuple(map(int, input().split(' ')))
    l.append(start)

    for _ in range(n) :
        cvs = tuple(map(int, input().split(' ')))
        l.append(cvs)

    end = tuple(map(int, input().split(' ')))
    l.append(end)

    q = deque()
    v = defaultdict(bool)
    q.append(start)
    v[start] = True

    while q:
        curx, cury = q.popleft()

        # 페스티벌 장소에 도착
        if curx == end[0] and cury == end[1] :
            succeed = True

        for e in l:
            # 1000미터 이내일 경우(맥주가 떨어지지 않음)
            if (abs(e[0] - curx) + abs(e[1] - cury) <= 1000) and not v[e]:
                v[e] = True
                q.append((e[0], e[1]))

    if succeed :
        print("happy")
    else :
        print("sad")