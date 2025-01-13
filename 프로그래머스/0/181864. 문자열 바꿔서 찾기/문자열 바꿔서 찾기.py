def solution(myString, pat):
    reversed = ''
    for s in myString:
        if s == 'A':
            reversed += 'B'
        else:
            reversed += 'A'
    return int(pat in reversed)