def solution(n):
    answer = []
    for i in range(n):
        row = []
        for j in range(n):
            if j == i:
                row.append(1)
            else:
                row.append(0)
        answer.append(row)
    return answer