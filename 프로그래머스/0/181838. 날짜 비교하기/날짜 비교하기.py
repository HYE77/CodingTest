def solution(date1, date2):
    return 1 if int(''.join([str(s) for s in date1])) < int(''.join([str(i) for i in date2])) else 0