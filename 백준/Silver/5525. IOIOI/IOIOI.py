
n = int(input())
m = int(input())
s = input()

pn = "I" + "OI" * n

ans = 0
count = 0
i = 0
while i < m-2 :
    if s[i] == 'I' and s[i+1] == 'O' and s[i+2] == 'I':
        count += 1
        if count == n : # 패턴이 n번 반복되면 찾은 것임
            ans += 1
            count -= 1 # 뒤에 또 'OI'가 나올 수 있으므로 하나만 줄인다
        i += 2 # 두 칸 당기기
    else :
        count = 0 # 초기화
        i += 1 # 하나씩 당기기

print(ans)