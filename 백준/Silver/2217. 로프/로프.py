n = int(input())
ropes = [int(input()) for _ in range(n)]

ropes.sort(reverse=True)

max_w = 0
for i in range(n):
    max_w = max(max_w, ropes[i] * (i + 1))

print(max_w)
