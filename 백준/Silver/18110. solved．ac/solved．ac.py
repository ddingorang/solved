import sys

n = int(sys.stdin.readline().rstrip())
nl = []
for _ in range(n) :
    nl.append(int(sys.stdin.readline().rstrip()))

def roundUp(x):
    if (x - int(x)) >= 0.5:
        return int(x)+1
    else:
        return int(x)

nl.sort()
cut = roundUp(n*0.15)
left = n - 2*cut
if left == 0:
    print(0)
else :
    average = roundUp(sum(nl[cut:n-cut])/left)
    print(average)