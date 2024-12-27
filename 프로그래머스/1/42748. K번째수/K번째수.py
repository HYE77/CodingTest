def solution(array, commands):
    answer = []
    for command in commands:
        i = command[0]
        j = command[1]
        k = command[2]
        new = array[i-1:j]
        new.sort()
        answer.append(new[k-1])
        
    return answer