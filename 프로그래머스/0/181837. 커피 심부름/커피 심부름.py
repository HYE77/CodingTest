def solution(order):
    ans = 0
    for _ in order:
        if 'cafelatte' in _:
            ans += 5000
        else: ans += 4500
    return ans