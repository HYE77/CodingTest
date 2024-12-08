def solution(nums):
    answer = 0
    from itertools import combinations
    for i in combinations(nums, 3):
        sums = sum(i)
        factor = 0
        for k in range(1, sums//2 + 1):
            if sums % k == 0:
                factor += 1
        if factor == 1:
            answer += 1
            

    return answer