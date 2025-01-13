def solution(myString):
    splt = myString.split('x')
    return [len(e) for e in splt]