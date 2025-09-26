def solution(s, n):
    result = ''
    for i in range(len(s)) :
        if s[i] == " ":  
            result += " "
        elif 'A' <= s[i] <= 'Z':  # 대문자
            result += chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif 'a' <= s[i] <= 'z':  # 소문자
            result += chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    
    return result