def solution(s):
    words = s.split(' ')
    new = []
    for word in words:
        if word == '':
            new.append(word)
        else:
            new.append(word[0].upper() + word[1:].lower())
    return ' '.join(new)