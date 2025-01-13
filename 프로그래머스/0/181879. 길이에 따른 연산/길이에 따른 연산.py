def solution(num_list):
    import math
    return sum(num_list) if len(num_list) >= 11 else math.prod(num_list)