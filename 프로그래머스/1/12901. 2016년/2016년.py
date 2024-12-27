def solution(a, b):
    dlist = [0, 1, -1, 1, 0, 1, 0, 1, 1, 0, 1, 0]
    days = 30 * (a-1) + sum(dlist[0:a]) + b
    days_list = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED']
    d = days % 7
    return days_list[d]