def solution(arr):
    ans = []
    for a in arr:
        if a >= 50 and a % 2 == 0:
            ans.append(a / 2)
        elif a < 50 and a % 2 == 1:
            ans.append(a * 2)
        else:
            ans.append(a)
    return ans