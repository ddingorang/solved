import sys
input = sys.stdin.readline

n = int(input())
answercnt = 0
start = 1
end = 1
sum = 1

while end != n:
    if sum < n :
        end += 1
        sum += end
    elif sum > n :
        sum -= start
        start += 1
    elif sum == n:
        answercnt += 1
        end += 1
        sum += end

answercnt += 1

print(answercnt)