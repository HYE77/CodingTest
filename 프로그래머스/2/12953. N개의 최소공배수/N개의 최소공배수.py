from math import gcd

def solution(arr):
    def lcm(x, y):
        return x * y // gcd(x, y)
    
    answer = arr[0]
    for num in arr[1:]:
        answer = lcm(answer, num)
    
    return answer
