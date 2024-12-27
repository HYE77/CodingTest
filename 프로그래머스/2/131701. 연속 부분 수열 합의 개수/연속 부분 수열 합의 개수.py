def solution(elements):
    l = len(elements)
    double = elements * 2
    sumlist = []
    for i in range(l): # 시작 index. 원형 수열 순회
        for j in range(1, l+1): # 길이가 j인 부분 수열
            sumlist.append(sum(double[i:i+j]))
    sumset = set(sumlist)
    return len(sumset)
            