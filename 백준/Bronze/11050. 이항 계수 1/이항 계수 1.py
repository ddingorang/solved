import sys
import math

n, m = map(int, sys.stdin.readline().split(' '))
print(math.comb(n, m))