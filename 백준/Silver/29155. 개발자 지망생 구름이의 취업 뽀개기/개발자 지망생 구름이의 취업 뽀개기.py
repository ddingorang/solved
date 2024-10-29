import sys

n = int(sys.stdin.readline().rstrip())
level = list(map(int, sys.stdin.readline().rstrip().split(' ')))
questions = []
for _ in range(n) :
    k, t = map(int, sys.stdin.readline().rstrip().split(" "))
    questions.append((k, t))

questions.sort() # 난이도 순으로 정렬 -> 그리디

lvl = questions[0][0] # 현재 레벨
total = 0 # 누계
for i in range(len(questions)) : # 문제 전부 순회
    # 목표 풀이 문제인 level 배열의 원소들을 하나씩 차감하여 목표 문제 개수만큼만 풀이
    if questions[i][0] == lvl and level[lvl-1] > 0 :
        if i == 0 : # 처음은
            total += questions[i][1] # 처음 문제에 소요되는 시간만 더함
        if questions[i][0] != questions[i-1][0] and i != 0: # 레벨 상승한 직후 (== 현재 문제와 직전 문제의 레벨이 다름)
            total = total + (60 + questions[i][1]) # 60을 더함
        elif i != 0:
            total = total + (questions[i][1] - questions[i-1][1] + questions[i][1])
            
        level[lvl-1] -= 1 # 풀었으면 해당 레벨의 목표 풀이 문제 수 차감
        if level[lvl-1] == 0: # 해당 레벨의 목표 문제를 다 풀었으면
            lvl += 1 # 다음 레벨로

print(total)