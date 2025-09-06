def solution(s):
    answer = 0
    dbl = s*2
    for i in range(len(s)):
        sub = dbl[i:i+len(s)]
        stack = []
        for j in range(len(sub)) :
            if not stack : 
                stack.append(sub[j]) 
                continue
            if ((stack[-1] == '[' and sub[j] == ']') 
            or (stack[-1] == '{' and sub[j] == '}') 
            or (stack[-1] == '(' and sub[j] == ')')) :
                stack.pop()
            else:
                stack.append(sub[j])
        if len(stack) == 0 :
            answer += 1
    
    return answer