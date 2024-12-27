def solution(s, skip, index):
    abc = 'abcdefghijklmnopqrstuvwxyz'
    for _ in skip:
        abc = abc.replace(_, '')
    ans = []
    for _ in s:
        new_index = (abc.index(_) + index) % len(abc)
        ans.append(abc[new_index])
    answer = ''.join(ans)
    return answer