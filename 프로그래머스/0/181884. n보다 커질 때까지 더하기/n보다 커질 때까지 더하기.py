def solution(numbers, n):
    sum = 0
    for number in numbers:
        sum += number
        if sum > n:
            return sum