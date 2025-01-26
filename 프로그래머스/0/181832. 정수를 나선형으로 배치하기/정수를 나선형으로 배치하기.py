def solution(n):
    ans = [[0 for _ in range(n)] for j in range(n) ]
    # 현재 위치
    row = 0
    col = 0
    # 테두리
    max_col = n - 1
    max_row = n - 1
    # 행동
    moves = ['R', 'D', 'L', 'U']
    move_index = 0
    
    ans[row][col] = 1
    for i in range(2, n**2 + 1):
        if moves[move_index % 4] == 'R':
            col += 1
            ans[row][col] = i
            if col == max_col:
                move_index += 1
        elif moves[move_index % 4] == 'D':
            row += 1
            ans[row][col] = i
            if row == max_row or ans[row+1][col] != 0:
                max_col -= 1
                move_index += 1
        elif moves[move_index % 4] == 'L':
            col -= 1
            ans[row][col] = i
            if col == 0 or ans[row][col-1] != 0:
                move_index += 1
                max_row -= 1
        else: # 'U'
            row -= 1
            ans[row][col] = i
            if ans[row-1][col] != 0:
                move_index += 1
    return ans
