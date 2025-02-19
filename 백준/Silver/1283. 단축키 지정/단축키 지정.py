import sys

n = int(sys.stdin.readline().rstrip())
words = [sys.stdin.readline().rstrip().split(" ") for _ in range(n)]  # 공백 유지

used_keys = set()  # 단축키로 사용된 문자 저장 (대소문자 구분 X)
result = []

for word_list in words:
    new_words = []
    shortcut_found = False  # 단축키가 이미 설정되었는지 여부

    # 1️⃣ 첫 글자를 먼저 확인
    for word in word_list:
        first_char = word[0].lower()

        if not shortcut_found and first_char not in used_keys:
            used_keys.add(first_char)  # 대소문자 구분 없이 저장
            used_keys.add(word[0])  # 대소문자 모두 저장
            new_words.append(f"[{word[0]}]{word[1:]}")
            shortcut_found = True
        else:
            new_words.append(word)

    # 2️⃣ 첫 글자가 이미 사용된 경우, 다른 문자 선택
    if not shortcut_found:
        for i in range(len(new_words)):
            word = new_words[i]

            for j, char in enumerate(word):
                lower_char = char.lower()

                if lower_char not in used_keys and char != " ":  # 공백 제외
                    used_keys.add(lower_char)
                    used_keys.add(char)
                    new_words[i] = word[:j] + f"[{char}]" + word[j+1:]
                    shortcut_found = True
                    break

            if shortcut_found:
                break

    result.append(" ".join(new_words))

# 출력
for line in result:
    print(line)
