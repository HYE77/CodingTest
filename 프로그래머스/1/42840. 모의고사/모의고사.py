def solution(answers):
    num1 = [1, 2, 3, 4, 5]
    num2 = [2, 1, 2, 3, 2, 4, 2, 5]
    num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    prob = len(answers)
    num11 = num1 * (prob // len(num1) + 1)
    num22 = num2 * (prob // len(num2) + 1)
    num33 = num3 * (prob // len(num3) + 1)
    one = 0
    two = 0
    three = 0
    for i in range(prob):
        if num11[i] == answers[i]:
            one += 1
        if num22[i] == answers[i]:
            two += 1
        if num33[i] == answers[i]:
            three += 1
    maxi = max(one, two, three)
    answer = []
    if one == maxi:
        answer.append(1)
    if two == maxi:
        answer.append(2)
    if three == maxi:
        answer.append(3)
    return answer