def solution(n, m, section): # n개 구역, 한 번에 m미터
    answer = 1
    i = section[0]
    
    for s in section:
        if s > i + m  - 1:
            i = s
            answer += 1
        
    return answer