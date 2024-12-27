def solution(babbling):
    words = {"aya": '1',
             "ye": '2',
             "woo": '3',
             "ma": '4'}
    new = []
    
    for bab in babbling:
        n = bab[:]
        for word in words:
            if word in bab:
                n = n.replace(word, words[word])
        new.append(n)
                
    answer = 0
    for n in new:
        if n.isnumeric() and ('11' not in n) and ('22' not in n) and ('33' not in n) and ('44' not in n):
            answer += 1
        
    return answer