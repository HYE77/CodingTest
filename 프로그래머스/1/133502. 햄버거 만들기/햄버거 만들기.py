# def solution(ingredient):
#     answer = 0
#     ingredient = ''.join([str(_) for _ in ingredient])
#     while '1231' in ingredient:
#         answer += ingredient.count('1231')
#         ingredient = ingredient.replace('1231', '')
    
#     return answer


# def solution(ingredient):
#     answer = 0
#     ingredient = ''.join([str(_) for _ in ingredient])
#     while '1231' in ingredient:
#         answer += 1
#         index = ingredient.index('1231')
#         ingredient = ingredient[0:index] + ingredient[index+4:]
        
#     return answer


def solution(ingredient):
    answer = 0
    stack = []
    for _ in ingredient:
        stack.append(_)
        if len(stack) >= 4 and stack[-4:] == [1, 2, 3, 1]:
            stack.pop()
            stack.pop()
            stack.pop()
            stack.pop()
            answer += 1
    return answer
            