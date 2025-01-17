def solution(str_list):
    for _ in range(len(str_list)):
        if str_list[_] == 'l':
            return str_list[:_]
        elif str_list[_] == 'r':
            return str_list[_+1:]
    return []