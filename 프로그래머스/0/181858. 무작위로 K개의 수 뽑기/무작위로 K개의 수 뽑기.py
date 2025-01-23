def solution(arr, k):
    ans = []
    for _ in arr:
        if _ not in ans:
            ans.append(_)
    if len(ans) < k:
        ans += [-1] * (k - len(ans))
    return ans[:k]