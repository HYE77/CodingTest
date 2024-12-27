def solution(s, n):
    up = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    low = 'abcdefghijklmnopqrstuvwxyz'
    llist = s.split(' ')
    answer_list = []
    for word in llist:
        if word == '':
            answer_list.append(word)
        else:
            new_word = ''
            for i in range(len(word)):
                if word[i] in up:
                    index = up.index(word[i])
                    new_word += up[(index  + n) % 26]
                elif word[i] in low:
                    index = low.index(word[i])
                    new_word += low[(index  + n) % 26]
            answer_list.append(new_word)
    return ' '.join(answer_list)