def solution(arr):
    row = len(arr)
    col = len(arr[0])
    if row > col:
        gap = row - col
        for r in arr:
            r += [0] * gap
    elif row < col:
        gap = col - row
        for i in range(gap):
            arr.append([0]*col)
    return arr