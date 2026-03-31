
aa, ah = map(int, input().split(' '))
ba, bh = map(int, input().split(' '))

aftera = ah
afterb = bh
while True:
    aftera -= ba
    afterb -= aa

    if aftera > 0 and afterb <= 0:
        print("PLAYER A")
        break
    elif aftera <= 0 and afterb > 0:
        print("PLAYER B")
        break
    elif aftera <= 0 and afterb <= 0 :
        print("DRAW")
        break