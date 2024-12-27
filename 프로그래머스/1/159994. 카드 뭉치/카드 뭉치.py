def solution(cards1, cards2, goal):
    result = 'Yes'
    while result == 'Yes' and len(goal) > 0:
        if len(cards1) > 0 and goal[0] == cards1[0]:
            goal.pop(0)
            cards1.pop(0)
        elif len(cards2) > 0 and goal[0] == cards2[0]:
            goal.pop(0)
            cards2.pop(0)
        else:
            result = 'No'
    return result
            