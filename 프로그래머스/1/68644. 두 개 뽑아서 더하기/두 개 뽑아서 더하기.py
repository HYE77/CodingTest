def solution(numbers):
    answer = []
    from itertools import combinations
    for combi in combinations(numbers, 2):
        answer.append(sum(combi))
    result = list(set(answer))
    result.sort()
    return result