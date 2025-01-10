def solution(n, control):
    for _ in control:
        if _ == 'w':
            n += 1
        elif _ == 's':
            n -= 1
        elif _ == 'd':
            n += 10
        else:
            n -= 10
    return n