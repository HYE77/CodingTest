def solution(intStrs, k, s, l):
    intStrs = [int(ints[s:s+l]) for ints in intStrs]
    return [i for i in intStrs if i > k]