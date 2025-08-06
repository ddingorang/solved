def solution(arr):
    newarr = sorted(arr)
    minnum = newarr[0]
    for e in arr:
        if e == minnum :
            arr.remove(e)
    if len(arr) == 0:
        return [-1]
    else :
        return arr