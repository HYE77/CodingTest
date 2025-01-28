def solution(d, budget):
    if sum(d) <= budget:
        return len(d)
    else:
        d.sort()
        for _ in range(len(d)-1, -1, -1):
            if sum(d[:_]) <= budget:
                return len(d[:_])