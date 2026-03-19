
n, m, k = map(int, input().split(' '))

fronto = m
frontx = n-m

backo = k
backx = n-k

if fronto > backo :
    print(backo + frontx)
elif fronto == backo:
    print(n)
else :
    print(fronto + backx)
