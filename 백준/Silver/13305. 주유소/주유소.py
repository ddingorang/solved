import sys

n = int(sys.stdin.readline().rstrip()) # 도시 개수
d = list(map(int, sys.stdin.readline().split(' '))) # 도시 사이 거리를 담은 리스트
o = list(map(int, sys.stdin.readline().split(' '))) # 각 도시에서의 기름 가격을 담은 리스트

cost = 0 # 누적 비용
minimum = o[0] # 매 도시 방문 시점에 가장 저렴한 기름 가격
cost += minimum * d[0] # 어차피 처음은 첫 도시에서 무조건 기름 구입해야 함

for i in range(1,len(o)-1) : # 매 도시 방문 마다
    if minimum > o[i] : # 만약 이 도시의 기름값이 이전 도시들보다 저렴할 때
        minimum = o[i] # 이 도시에서 기름을 사야 함, 최소 가격도 갱신
        cost += o[i]*d[i]
    else : # 아니라면
        cost += minimum * d[i] # 이전에 가장 저렴했던 도시에서 미리 기름을 사 놓는게 더 저렴함

print(cost)

# 제일 저렴한 도시에서 앞으로 가야할 거리만큼 최대한 많이 사놓는게 저렴함
# 도시를 지나오면서, 이때까지 지나온 도시 중에 최저가라면 그 도시에서 사야되고
# 아니라면? 최저가인 도시에서 미리 내가 지금까지 지나온 거리만큼 사는게 저렴