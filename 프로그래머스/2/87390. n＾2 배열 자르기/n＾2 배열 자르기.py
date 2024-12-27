def solution(n, left, right):
    result = []
    row = (left + 1) // n + 1
    
    left -= n * (row - 1)
    right -= n * (row - 1)
    
    for j in range(1, n + 1):
        if j < row:
            continue
        else:
            l = [j] * (j - 1) + [k for k in range(j, n + 1)]
            result += l
            if len(result) + 1 >= right:
                break
    
    return result[left:right+1]
 