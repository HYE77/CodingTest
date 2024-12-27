def solution(s):
    already = []
    result = []
    for i in range(len(s)):
        if s[i] not in already:
            already.append(s[i])
            result.append(-1)
        else: 
            a_index = ''.join(already).rindex(s[i])
            already.append(s[i])
            result.append(i - a_index)
    return result