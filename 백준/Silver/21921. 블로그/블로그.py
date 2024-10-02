import sys

n, x = map(int, sys.stdin.readline().split(' '))
v = list(map(int, sys.stdin.readline().split(' ')))

if sum(v) != 0 :
    accum = [0] # 누적합 저장
    s = 0
    for e in v:
        s += e
        accum.append(s) # 누적합 append

    mx = 0 # 최댓값
    cnt = 0 # 최댓값이 나온 횟수
    for i in range(len(v)-x+1) :
        ps = accum[i+x] - accum[i] # n-m까지의 구간합 = (m까지의 누적합) - (n-1까지의 누적합)
        if ps > mx : # 새로운 최댓값 나오면
            mx = ps # 최댓값 교체
            cnt = 1 # 카운트도 1로 초기화
        elif ps == mx : # 기존 최댓값 또 나오면
            cnt += 1 # 카운트 증가

    print(mx) # 최댓값과
    print(cnt) # 그 횟수
    
else : # 최댓값이 0이라는 것은 방문자 수가 모두 0이라는 뜻임(방문자 수는 0 이상)
    print('SAD')