import sys

duck = list(sys.stdin.readline().rstrip())
used = [1 for _ in range(len(duck))] # 수집한 알파벳 체크
shouldfind = ['q', 'u', 'a', 'c', 'k']
duckcount = 0 # 오리 마리수

# 전체 문자열을 순회하면서, 알파벳을 하나씩 수집하는 개념
# q, u, a, c, k를 순서대로 수집해야 함

while 1 :
    oneduckfound = False # 문자열을 전부 순회하는 동안 모은 문자들을 집합으로 저장
    idx = 0 # shouldfind의 인덱스(q, u, a, c, k)
    temp = []
    # 수집된 알파벳들의 문자열에서의 인덱스를 임시 저장
    # 수집한 순간 수집 체크를 하는 것이 아니라, 5개 알파벳을 순서대로 다 수집했을 때 한꺼번에 수집 체크
    # 수집하다가 중간에 끊길 수도 있기 때문
    for i in range(len(duck)) : # 문자열을 한번 순회하는 동안
        if duck[i] == shouldfind[idx] and used[i] == 1: # 찾았으면
            idx += 1
            temp.append(i) # 문자열에서의 그 알파벳의 인덱스를 임시 저장
            if idx > 4 : # q, u, a, c, k가 다 모여야
                oneduckfound = True # 일단 한마리 있는 것은 확인
                idx = 0 # 다시 q부터 찾기
                for e in temp :
                    used[e] = 0 # 수집 체크함
                temp = [] # 초기화
    if oneduckfound == 1 : duckcount += 1 # 찾았으면 오리 카운트 증가
    else : break # 한 마리 더 못 찾았으면 순회 종료

if sum(used) != 0 : print(-1) # 문자열이 전부 사용되지 않으면 유효한 울음소리가 아님...
else :
    print(duckcount)