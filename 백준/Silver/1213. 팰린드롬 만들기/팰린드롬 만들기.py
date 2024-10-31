import sys
from collections import defaultdict

letters = list(sys.stdin.readline().rstrip())
howmany = defaultdict(int)
isPossible = True # 팰린드롬을 만들 수 있는지 여부
oneChecked = False # dict의 value가 홀수인 key가 존재하는 여부
for e in letters:
    howmany[e] += 1 # 철자별로 개수 체크

howmany = dict(sorted(howmany.items())) # 알파벳 순서로 정렬

# 팰린드롬 만들려면
# 1. 철자 개수가 모두 짝수개
# 2. 개수가 홀수개인 철자 하나 + 나머지 철자는 모두 짝수개
# 만드는 방식 : 먼저 반쪽 만들고, 그 반쪽을 뒤집은 것을 먼저 만든 반쪽 뒤에 붙임

s = '' # 팰린드롬 반쪽 저장
rs = '' # s를 뒤집은 문자열
res = '' # 홀수개인 철자는 한 개가 남음 -> 팰린드롬 가운데에 배치
for l in howmany :
    if howmany[l] % 2 != 0 :
        if oneChecked == True: # 이미 홀수개인 key가 있음 -> 홀수개가 있는 key가 또 있으면 팰린드롬 만들 수 없음
            isPossible = False
            break
        s += l * (howmany[l] // 2)
        res = l # 남는 철자 하나 저장
        oneChecked = True
    else :
        s += l * (howmany[l] // 2) # 개수 중 절반을 반쪽 만드는데 사용

if isPossible == True:
    s = s + res + s[::-1] # 반쪽 먼저 놓고 + 철자 하나 남는거 놓고 + 그 다음 반쪽을 뒤집은 문자열 붙이기 = 완성
    print(s)
else :
    print("I'm Sorry Hansoo") # 불가능하면 출력
