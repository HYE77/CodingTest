# from math import *

# def solution(number):
#     n = len(number) # 학생 수
#     total_case = (factorial(n) / (factorial(3) * factorial(n-3))) # 3명을 뽑는 전체 케이스의 수 
    
#     answer = 0
#     for i in range(len(number)):
#         for j in range(i + 1, len(number)):
#             for k in range(j + 1, len(number)):
#                 if number[i] + number[j] + number[k] == 0:
#                     answer += 1
                
#     return answer

from itertools import combinations

def solution(number):
    answer = 0
    for i in combinations(number, 3):
        if sum(i) == 0:
            answer += 1
    return answer