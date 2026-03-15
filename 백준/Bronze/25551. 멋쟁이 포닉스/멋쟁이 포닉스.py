wm, bm = map(int, input().split())
ws, bs = map(int, input().split())
wp, bp = map(int, input().split())

combone = min(wm, bs, wp)
combtwo = min(bm, ws, bp)

if abs(combone - combtwo) <= 1:
    print(combone + combtwo)
elif combone == 0 and combtwo == 0:
    print(0)
else :
    minn = min(combone, combtwo)
    print(minn*2+1)