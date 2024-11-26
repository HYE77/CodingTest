def solution(numbers):
    sum = 0
    for item in numbers:
        sum += item
    answer = sum / len(numbers)
    return answer