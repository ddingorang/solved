import sys

n = int(sys.stdin.readline().rstrip())
paper = [] # 종이
answer = [0, 0] # 흰색, 파란색 종이 개수 저장
for _ in range(n) :
    paper.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))

def recur(r, c, l) :
    global paper
    global answer
    color = paper[r][c] # 맨 왼쪽 최상단 구역의 색상
    passed = True # 재귀로 탐색할 분할된 구역 전부 같은 색이면 pass
    for i in range(r, r+l) : # 전부 같은 색인지 탐색
        for j in range(c, c+l) :
            if paper[i][j] != color : # 아니라면
                passed = False # false로 바꾸고
                break # 탐색 종료
    if passed == True: # 전부 같은 색이면, 그 구역은 색종이 한 장으로 인정
        if color == 0 : answer[0] += 1 # 흰색이면 흰색 한장 추가
        else : answer[1] += 1 # 검정색
    else : # 4개 구역으로 분할하여 재귀적으로 정복
        recur(r, c, l//2) # 왼쪽 상단 구역
        recur(r + l//2, c, l // 2) # 왼쪽 하단 구역
        recur(r, c+l//2, l//2) # 오른쪽 상단 구역
        recur(r+l//2, c+l//2, l//2) # 오른쪽 하단 구역

recur(0, 0, n)
for e in answer:
    print(e)