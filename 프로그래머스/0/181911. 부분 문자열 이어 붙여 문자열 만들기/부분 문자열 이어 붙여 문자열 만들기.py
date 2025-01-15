def solution(my_strings, parts):
    answer = ''
    for word, index in zip(my_strings, parts):
        answer += word[index[0]: index[1]+1]
    return answer