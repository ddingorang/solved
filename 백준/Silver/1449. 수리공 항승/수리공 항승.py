import sys

n, m = map(int, sys.stdin.readline().split(' '))
l = list(map(int, sys.stdin.readline().rstrip().split(' ')))
l.sort() # 그리디 하기 위해 정렬해야함(오름차순)
count = 0 # 테이프 장수 저장
cur = 0 # 테이프를 붙이고 난 후의 오른쪽 끝의 위치

for idx, e in enumerate(l) : # 구멍들을 순회
    if idx != 0 and cur > e :
        continue # 첫 구멍이 아니고, 그 구멍이 테이프에 의해 막아졌을 경우 패스
    else : # 첫 구멍이거나, 막히지 않은 구멍이라면
        count += 1 # 테이프 장수 하나 증가
        cur = e + m # 테이프의 오른쪽 끝의 위치는 그 구멍의 위치 + 테이프 길이

print(count)