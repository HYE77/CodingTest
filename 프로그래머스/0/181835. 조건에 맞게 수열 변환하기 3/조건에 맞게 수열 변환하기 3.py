def solution(arr, k):
    if k % 2 == 1: # 홀수
        return [i*k for i in arr]
    else:
        return [i+k for i in arr]