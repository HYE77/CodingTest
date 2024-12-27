def solution(s):
    count = 0
    zero = 0
    while s != '1':
        zero += s.count('0')
        temp = s.replace('0', '')
        c = len(temp)
        s = bin(c)[2:]
        count += 1
    return [count, zero]