def solution(arr):
    ans = []
    for a in arr:
        ans += [a] * a
    return ans