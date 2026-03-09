from queue import PriorityQueue

n = int(input())
pq = PriorityQueue()

for _ in range(n):
    pq.put(int(input()))

c1 = 0
c2 = 0
summ = 0

# 제일 작은 두 묶음을 먼저 비교해야 최소 횟수의 비교임 -> 그리디
# 최소인 두 묶음을 뽑기 위해 우선순위 큐 활용

while pq.qsize()>1:
    c1 = pq.get()
    c2 = pq.get()
    summ += (c1 + c2)
    pq.put(c1 + c2) # 비교 완료 후 큐에 넣기

print(summ)