import sys

s = sys.stdin.readline().rstrip()
ns = ''
for i in range(len(s)) :
    if ord(s[i]) >= 97 :
        ns += chr(ord(s[i])-32)
    else :
        ns += chr(ord(s[i])+32)

print(ns)