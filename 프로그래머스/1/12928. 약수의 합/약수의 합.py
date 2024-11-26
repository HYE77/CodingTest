def solution(n):
    alist = [i for i in range(1, n+1)]
    ylist = list(filter(lambda x: n % x == 0, alist))
    answer = sum(ylist)
    return answer