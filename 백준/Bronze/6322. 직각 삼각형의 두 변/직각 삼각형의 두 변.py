import math

result = []
while True:
    a, b, c = map(int, input().split(' '))
    possible = True
    if a == 0 and b == 0 and c == 0:
        break

    if a == -1:
        possible_a = (c**2) - (b**2)
        if possible_a <= 0 : possible = False
        else :
            aftersqrt = math.sqrt(possible_a)
            result.append(('a', aftersqrt))

    elif b == -1:
        possible_b = (c**2) - (a**2)
        if possible_b <= 0 : possible = False
        else :
            aftersqrt = math.sqrt(possible_b)
            result.append(('b', aftersqrt))

    elif c == -1:
        possible_c = math.sqrt((a**2) + (b**2))
        result.append(('c', possible_c))

    # 직각삼각형 만들기 불가
    if not possible:
        result.append(('null', -1))

for idx, e in enumerate(result):
    print(f'Triangle #{idx+1}')
    if e[1] == -1:
        print("Impossible.")
    else :
        print(f'{e[0]} = {e[1]:.3f}')
    print()