import sys

l = []
target = 0
for _ in range(3):
    s = sys.stdin.readline().rstrip()
    l.append(s)

for i in range(3) :
    try :
        if int(l[i]) :
            diff = 3 - i
            target = int(l[i]) + diff
    except ValueError :
        continue

if target % 3 == 0 and target % 5 == 0 :
    print('FizzBuzz')
elif target % 3 == 0 :
    print('Fizz')
elif target % 5 == 0 :
    print('Buzz')
else :
    print(target)