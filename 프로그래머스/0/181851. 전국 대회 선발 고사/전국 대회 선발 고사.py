def solution(rank, attendance):
    yes = []
    for i, r in enumerate(rank):
        if attendance[i] == True:
            yes.append((r, i))
    yes.sort(key = lambda x: x[0])
    a, b, c = yes[0][1], yes[1][1], yes[2][1]
    return 10000*a + 100*b + c