
def solution(s):
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    chtonum = []
    for i in range(10) :
        if words[i] in s:
            chtonum.append(i)
    
    for ctn in chtonum:
        s = s.replace(words[ctn], str(ctn))
        
    answer = int(s)
    return answer