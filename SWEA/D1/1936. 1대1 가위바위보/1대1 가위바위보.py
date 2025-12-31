a, b = tuple(map(int, input().split(' ')))
 
whowon = ''
if a < b :
    whowon = 'B'
    if a == 1 and b == 3 :
        whowon = 'A'
else :
    whowon = 'A'
    if a == 3 and b == 1 :
        whowon = 'B'
 
print(whowon)