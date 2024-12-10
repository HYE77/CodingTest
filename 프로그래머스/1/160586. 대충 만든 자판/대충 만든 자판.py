def solution(keymap, targets):
    answer = []
    for target in targets:
        cant = False
        count = 0
        for j in range(len(target)):
            keys = [key for key in keymap if target[j] in key]
            if len(keys) == 0:
                cant = True # 못 만들어
                answer.append(-1)
                break
            indexes = []
            for key in keys:
                indexes.append(key.index(target[j]) + 1)
            count += min(indexes)
        if cant == False:
            answer.append(count)
        
    return answer