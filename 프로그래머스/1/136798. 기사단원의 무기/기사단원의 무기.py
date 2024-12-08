def solution(number, limit, power):
    answer = 0
    for i in range(1, number + 1):
        factor = 0
        for k in range(1, int(i ** 0.5) + 1):
            if i % k == 0:
                factor += 1
                if k ** 2 != i:
                    factor += 1
        if factor > limit:
            answer += power
        else:
            answer += factor
    
    return answer