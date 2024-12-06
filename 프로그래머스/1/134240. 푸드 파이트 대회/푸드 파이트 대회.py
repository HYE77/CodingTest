def solution(food):
    answer = ''
    for i in range(1, len(food)):
        answer += (str(i) * int((food[i]) // 2))
    result = answer + '0' + answer[::-1]
    return result