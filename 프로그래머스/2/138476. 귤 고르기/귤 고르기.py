def solution(k, tangerine):
    from collections import Counter
    dict = Counter(tangerine)
    
    if any(v >= k for v in dict.values()):
        return 1
    else:
        count = 0
        
        values = list(dict.values())
        values.sort(reverse = True)
        
        sums = values[0]
        for i in range(1, len(values)+1):
            sums += values[i]
            if sums >= k:
                return i + 1
