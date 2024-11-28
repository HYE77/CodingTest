def solution(price, money, count):
    answer = money - count * (count + 1) * price / 2
    return answer * (-1) if answer < 0 else 0