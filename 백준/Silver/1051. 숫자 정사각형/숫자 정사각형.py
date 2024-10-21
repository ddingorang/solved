import sys

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
maximum = 0
numbers = []
for _ in range(n) :
    numbers.append(list(map(int, sys.stdin.readline().rstrip())))

for i in range(min(n, m)) : # 정사각형 크기 점차 늘려가면서 브루트포스하게 찾기, 정사각형의 한 변의 최대 길이는 직사각형 배열 두 변 중 작은 값으로
    for j in range(n) :
        for k in range(m) :
            if j+i < n and k+i < m : # 꼭짓점이 배열 범위 초과하지 않게
                if numbers[j][k] == numbers[j+i][k] == numbers[j][k+i] == numbers[j+i][k+i] : # 네 꼭짓점 다 같으면
                    maximum = i+1

print(maximum**2)
