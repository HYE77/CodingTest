def solution(myString):
    return sorted([_ for _ in myString.split('x') if _ != ''])