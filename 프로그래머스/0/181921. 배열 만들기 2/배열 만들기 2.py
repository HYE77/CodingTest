def solution(l, r):
    answer = []
    for _ in range(l, r+1):
        if set(str(_)) in [{'5'}, {'0'}, {'0', '5'}]:
            answer.append(int(_))
    if len(answer) == 0:
        return [-1]
    return answer