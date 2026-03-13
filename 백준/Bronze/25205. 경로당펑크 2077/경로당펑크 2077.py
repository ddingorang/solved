
n = int(input())
m = ['y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm']
s = input()
lastletter = s[n-1]

if lastletter in m:
    print(0)
else :
    print(1)
