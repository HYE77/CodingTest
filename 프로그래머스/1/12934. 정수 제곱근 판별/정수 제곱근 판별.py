from math import *

def solution(n):
    answer = (sqrt(n) + 1) ** 2 if sqrt(n) ==  int(sqrt(n)) else -1
    return answer