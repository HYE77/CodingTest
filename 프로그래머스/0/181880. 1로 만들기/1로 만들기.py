def solution(num_list):
    answer = 0
    for num in num_list:
        while num != 1:
            answer += 1
            if num % 2 == 0:
                num /= 2
            else:
                num = (num-1) / 2
    return answer