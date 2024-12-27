
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
            