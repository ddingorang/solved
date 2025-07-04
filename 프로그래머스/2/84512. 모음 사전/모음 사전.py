from itertools import product
def solution(word):
    wordlist = ['A', 'E', 'I', 'O', 'U']
    
    d = []
    for i in range(1, 6) :
        for c in product(wordlist, repeat = i) : # 모든 조합 생성(cartesian product)
            d.append(''.join(c))
    
    d.sort() # 사전순대로 정렬
    answer = d.index(word) + 1
    
    return answer