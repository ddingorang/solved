from collections import deque
n = int(input(''))
t = list(input('').split(' '))
cur = list(input('').split(' '))
l = int(input(''))
temp = list(input('').split(' '))

result = []
q = deque()

# stack은 어차피 다음으로 넘어갈 원소가 그대로 다음 자로구조로 넘어감 -> 없는 셈 쳐도 됨
# 그래서 queue만 남기기
# 그러면 자료구조들이 모여있는 형태 자체가 queue가 됨
for i in range(n) :
    if t[i] == '0' :
        q.append(cur[i])

for tp in temp:
    q.appendleft(tp)
    result.append(q.pop())

for e in result:
    print(e, end=' ')