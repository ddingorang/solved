
t = int(input())
result = []

for _ in range(t) :
    n, m = map(int, input().split())
    bottom = list(map(int, input().split()))
    left = list(map(int, input().split()))

    cnt = 0;
    for i in range(len(bottom)) :
        if bottom[i] in left:
            cnt += 1

    result.append(cnt)

for e in result:
    print(e)