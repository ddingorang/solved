n = int(input())

if n==1 : print(0)
else:
    if n % 2 == 0 : print(int(n*n/2))
    else : print(int((n*n+1)/2))