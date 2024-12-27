def solution(k, m, score):
    answer = 0
    score.sort(reverse = True)
    for i in range(len(score) // m):
        if m * (i+1) <= len(score):
            price = min(score[m*i: m*(i+1)])
            answer += price * m
        else: 
            break
    return answer