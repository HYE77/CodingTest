def solution(want, number, discount):
    from collections import Counter
    answer = 0
    
    want_dict = {want[i]:number[i] for i in range(len(want))}
    
    for i in range(len(discount)):
        sale_list = discount[i: i+10]
        if len(sale_list) == 10 and Counter(sale_list) == want_dict:
            answer += 1
    
    return answer