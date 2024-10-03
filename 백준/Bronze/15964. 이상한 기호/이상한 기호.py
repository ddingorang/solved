import sys

a, b= map(int, sys.stdin.readline().split(' '))

def func(x, y) :
    return (x + y)*(x - y)

print(func(a, b))