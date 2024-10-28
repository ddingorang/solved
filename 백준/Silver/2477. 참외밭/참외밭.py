import sys
from collections import deque

k = int(sys.stdin.readline().rstrip())
count = [0 for _ in range(5)]
sides = deque()
for _ in range(6):
    s, l = map(int, sys.stdin.readline().rstrip().split(' '))
    sides.append((s, l))
    count[s] += 1

full = []
ones = []
for i in range(1, 5) :
    if count[i] == 1 :
        ones.append(i)
        for e in sides:
            if e[0] == i :
                full.append(e[1])

fullsize = full[0]*full[1]

j=0
while sides[j][0] != ones[0] :
    sides.append(sides.popleft())

if ones == [2, 3] :
    front = 4
    rear = 1
elif ones == [1, 3] :
    front = 2
    rear = 4
elif ones == [1, 4] :
    front = 3
    rear = 2
elif ones == [2, 4] :
    front = 1
    rear = 3

substract = 0
for s in range(1, 6) :
    temp = sides[s-1][0]
    now = sides[s][0]
    if temp == front and now == rear :
        substract = sides[s-1][1] * sides[s][1]

num = (fullsize - substract)*k
print(num)
