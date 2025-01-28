def solution(N, stages):
    rate = {num: [0, 0] for num in range(1, N+1)}
    for person in stages:
        if person in rate:
            rate[person][0] += 1
        else:
            person = N
        for stage in range(1, person+1):
            rate[stage][1] += 1
    fail_rate = []
    for a, b in rate.values():
        if b == 0:
            fail_rate.append(0)
        else:
            fail_rate.append(a/b)
        
    fail_rate_cap = [(stage+1, rate) for stage, rate in enumerate(fail_rate)]
    fail_rate_cap.sort(key = lambda x: (-x[1], x[0]))
        
    return [s[0] for s in fail_rate_cap]