import sys
from collections import defaultdict

n, d = map(int, sys.stdin.readline().rstrip().split(' '))
road = defaultdict(list)
junctions = set() # 지름길과 원래 길이 만나는 분기점
dp = [0 for _ in range(10000)]
for _ in range(n) :
    a, b, c = map(int, sys.stdin.readline().rstrip().split(' '))
    road[b].append((a, c)) # 지름길 추가
    junctions.add(a) # 분기점 추가
    junctions.add(b)
junctions.add(d) # 분기점에 도착지도 추가
s_junctions = sorted(junctions) # 분기점을 순서대로 정렬

for idx, e in enumerate(s_junctions): # 분기점을 순회
    if idx == 0 :
        dp[e] = e # 처음은 그냥 원점과 그 사이 거리임
        continue
    if road[e] : # 지름길 끝과 만나는 분기점이라면
        tmp = []
        for i in range(len(road[e])) :
            one = min(dp[road[e][i][0]] + road[e][i][1], dp[s_junctions[idx-1]] + (e-s_junctions[idx-1]))
            tmp.append(one)
            # 1. 지름길을 통해서 온 거리
            # 2. 지름길을 타지 않고 (이전 분기점까지 온 거리 + 이전 분기점 사이 거리)
            # 1, 2중 최소값
        dp[e] = min(tmp)
    else : # 지름길이 시작하는 분기점이라면
        dp[e] = dp[s_junctions[idx-1]] + (e-s_junctions[idx-1]) # 그냥 이전 분기점과의 거리 차이를 더함

print(dp[d])