def solution(name, yearning, photo):
    answer = []
    dict = {name[i]: yearning[i] for i in range(len(name))}
    
    for p in photo:
        yearn = 0
        for i in range(len(p)):
            if p[i] in dict:
                yearn += dict[p[i]]
        answer.append(yearn)
    return answer