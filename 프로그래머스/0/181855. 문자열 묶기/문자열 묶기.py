def solution(strArr):
    length = set([len(i) for i in strArr])
    len_dict = {l: 0 for l in length}
    for s in strArr:
        len_dict[len(s)] += 1
    return max(len_dict.values())