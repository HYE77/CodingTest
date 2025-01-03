def solution(clothes):
    answer = 1
    c_dict = {}
    for cloth in clothes:
        if cloth[-1] in c_dict:
            c_dict[cloth[-1]] += 1
        else:
            c_dict[cloth[-1]] = 1
            
    for v in c_dict.values():
        answer *= v+1
    
    return answer - 1