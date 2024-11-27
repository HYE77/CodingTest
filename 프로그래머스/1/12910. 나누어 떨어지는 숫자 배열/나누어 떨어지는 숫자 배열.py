def solution(arr, divisor):
    answer = list(filter(lambda x: x % divisor == 0, sorted(arr)))
    return answer if len(answer) != 0 else [-1]