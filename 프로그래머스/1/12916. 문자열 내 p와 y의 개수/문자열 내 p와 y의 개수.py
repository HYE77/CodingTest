def solution(s):
    
    p = s.count('p') + s.count('P')
    y = s.count('y') + s.count('Y')
    return False if p != y else True