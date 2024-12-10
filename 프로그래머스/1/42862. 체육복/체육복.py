def solution(n, lost, reserve):
    # 잃어버렸는데 여벌이 있는 학생 찾아서 중복 제거
    common = set(lost) & set(reserve)
    for c in common:
        lost.remove(c)
        reserve.remove(c)
        
    student = n - len(lost)
    
    lost.sort()
    reserve.sort()
    
    for l in lost:
        if (l - 1) in reserve:
            reserve.remove(l-1)
            student += 1
        elif (l + 1) in reserve:
            reserve.remove(l+1)
            student += 1

    return student