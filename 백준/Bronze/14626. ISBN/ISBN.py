isbn = input('')
summ = 0
missing = 0
for i in range(len(isbn)):
    if isbn[i] == '*' :
        missing = i
        continue
    if i % 2 == 0:
        summ += int(isbn[i])
    elif i % 2 != 0:
        summ += 3 * int(isbn[i])

for k in range(10) :
    total = -1
    if missing % 2 == 0 :
        total = summ + k
    elif missing % 2 != 0 :
        total = summ + k*3
    if total % 10 == 0:
        print(k)