def solution(priorities, location):
    task = [i for i in range(len(priorities))]
    my_task = task[location]
    done = []
    
    while priorities:
        if priorities[0] != max(priorities):
            priorities.append(priorities.pop(0))
            task.append(task.pop(0))
        else:
            priorities.pop(0)
            done.append(task.pop(0))
            
    return done.index(my_task) + 1
            