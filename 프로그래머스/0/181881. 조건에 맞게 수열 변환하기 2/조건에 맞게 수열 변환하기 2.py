def solution(arr):
    x = 0
    while True:
        new_arr = []
        for item in arr:
            if item >= 50 and item % 2 == 0:
                new_arr.append(item // 2)
            elif item < 50 and item % 2 == 1:
                new_arr.append(item * 2 + 1)
            else:
                new_arr.append(item)
        if new_arr == arr:
            return x
        x += 1
        arr = new_arr