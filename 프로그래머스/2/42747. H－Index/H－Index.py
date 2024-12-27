def solution(citations):
    hs = []
    citations.sort(reverse = True)
    
    for h in range(len(citations) + 1):
        if len([c for c in citations if c >= h]) >= h:
            hs.append(h)
    return max(hs)