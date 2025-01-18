import math
def solution(arr):
    while math.log2(len(arr)) != int(math.log2(len(arr))):
        arr.append(0)
    return arr