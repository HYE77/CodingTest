def solution(arr):
    if arr.count(2) > 1:
        start = arr.index(2)
        end = arr[::-1].index(2)
        if arr[-1] == 2:
            return arr[start:]
        return arr[start:-end]
    elif arr.count(2) == 1:
        return [2]
    else:
        return [-1]