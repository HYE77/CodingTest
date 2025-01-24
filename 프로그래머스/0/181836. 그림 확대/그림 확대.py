def solution(picture, k):
    ans = []
    row = len(picture)
    
    for r in picture:
        l = ''
        for w in r:
            l += w * k
        for i in range(k):
            ans.append(l)
    return ans