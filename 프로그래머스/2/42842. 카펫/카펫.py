def solution(brown, yellow):
    answer = []
    nlist = [i for i in range(1, brown + 1)]
    for a in range(1, brown):
        for b in range(1, a+1):
            if (a*b == yellow + brown) and (a + b == (brown - 2) // 2 + 3):
                answer.append(a)
                answer.append(b)
                break
    return answer