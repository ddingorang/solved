def solution(s):
    words = s.split(' ')
    result = []

    for word in words:
        temp = ''
        for i, char in enumerate(word):
            if i % 2 == 0:
                temp += char.upper()
            else:
                temp += char.lower()
        result.append(temp)

    return ' '.join(result)
