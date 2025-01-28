def solution(n, arr1, arr2):
    bit_arr1 = [bin(i)[2:] for i in arr1]
    bit_arr2 = [bin(j)[2:] for j in arr2]
    
    bit1 = []
    for b in bit_arr1:
        if len(b) < n:
            new_b = '0' * (n - len(b)) + b
            bit1.append(new_b)
        else:
            bit1.append(b)
    
    bit2 = []        
    for b in bit_arr2:
        if len(b) < n:
            new_b = '0' * (n - len(b)) + b
            bit2.append(new_b)
        else:
            bit2.append(b)
    
    map = []
    for a, b in zip(bit1, bit2):
        new = ''
        for i in range(n):
            if a[i] == '1' or b[i] == '1':
                new += '#'
            else:
                new += ' '
        map.append(new)
    return map