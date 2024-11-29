# point 1: '단어(공백)을 기준으로 홀짝 인덱스 판단'. 즉, 공백이 등장할 때마다 인덱스 초기화. 단어마다의 인덱스 홀짝 여부로 판단.

def solution(s):
    words = s.split(' ')
    new = []
    for word in words:
        if word.isalpha():
            word = word.lower()
            new_word = ''
            for i in range(len(word)):
                if i % 2 == 0: # 짝수 인덱스
                    new_word += word[i].upper()
                else:
                    new_word += word[i] # 홀수 인덱스 
            new.append(new_word)
        elif word == '':
            new.append(word)
    return ' '.join(new)