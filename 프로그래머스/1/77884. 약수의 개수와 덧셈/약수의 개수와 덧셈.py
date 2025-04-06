import math
def solution(left, right):
    toplus = [] # 약수가 짝수개인 수는 더하고
    tominus = [] # 약수가 홀수개인 수는 빼기
    for i in range(left, right+1) :
        count = 0
        for j in range(1, int(math.sqrt(i)) + 1): # 제곱근까지만 구하기, 개수 +2하면 되니까
            if i % j == 0:
                count += 2 if j != i // j else 1
        if count % 2 == 0:
            toplus.append(i)
        else :
            tominus.append(i)
        
    answer = sum(toplus) - sum(tominus)
    return answer