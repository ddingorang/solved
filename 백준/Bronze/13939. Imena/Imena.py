n = int(input())
eos = ['.', '?', '!']
words = input().split()

result = []
temp = 0
for w in words:
    hasdigit = False
    for c in w:
        if c.isdigit(): hasdigit = True
    if w[0].isupper() and not hasdigit:
        temp += 1
    if w[-1] in eos:
        result.append(temp)
        temp = 0

for e in result:
    print(e)
