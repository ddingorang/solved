
n = int(input())
clist = []
for _ in range(n) :
    clist.append(input())

result = ''
kbs1 = clist.index("KBS1")
kbs2 = clist.index("KBS2")
if kbs1 > kbs2 :
    kbs2 += 1

for _ in range(kbs1) :
    result += '1'
for _ in range(kbs1):
    result += '4'

for i in range(kbs2) :
    result += '1'
for j in range(kbs2-1) :
    result += '4'

print(result)