def solution(myString):
    answer = ''
    for _ in list(myString):
        if ord(_) < ord('l'):
            answer += 'l'
        else:
            answer += _
    return answer