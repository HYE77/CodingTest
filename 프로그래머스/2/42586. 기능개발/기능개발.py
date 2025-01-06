def solution(progresses, speeds):
    import math
    from collections import Counter
    
    rest = [100 - progresses[i] for i in range(len(progresses))]
    days = [math.ceil(rest[i] / speeds[i]) for i in range(len(rest))]
    
    for i in range(1, len(days)):
        if days[i] < days[i-1]:
            days[i] = days[i-1]
            
    return list(Counter(days).values())