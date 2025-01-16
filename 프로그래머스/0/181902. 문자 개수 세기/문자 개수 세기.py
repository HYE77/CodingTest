def solution(my_string):
    alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'
    dict = {alphabet: 0 for alphabet in alphabets}
    for _ in my_string:
        dict[_] += 1
    return list(dict.values())