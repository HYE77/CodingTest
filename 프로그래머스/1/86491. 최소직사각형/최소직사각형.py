def solution(sizes):
    a = []
    b = []
    # 큰 숫자가 앞에 오도록 순서 변경
    for x, y in sizes:
        if x < y:
            x, y = y, x
        a.append(x)
        b.append(y)
        
    return max(a) * max(b)