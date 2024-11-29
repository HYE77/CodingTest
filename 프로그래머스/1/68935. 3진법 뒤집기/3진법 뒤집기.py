def solution(n):
    answer = []
    while n > 0:
        answer.append(n % 3)
        n //= 3
    answer.reverse() # 삼진법 표현 완성. 굳이 다시 뒤집을 필요 X
    result = 0
    for i, number in enumerate(answer):
        result += (3 ** i) * number  
    return result