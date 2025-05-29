import sys
input = sys.stdin.readline

N, M = map(int, input().split())

chess1 =  [list('WBWBWBWB'), list('BWBWBWBW')] * 4
chess2 = [list('BWBWBWBW'), list('WBWBWBWB')] * 4

board = []
for _ in range(N):
    board.append(list(input()))
    
x = M - 7
y = N - 7

need_to_color = 99999

for i in range(x):
    for j in range(y):
        part = [line[i:i+8] for line in board[j:j+8]]
        diff1 = 0 # compare to chess1 
        diff2 = 0 # compare to chess2
        for k in range(8):
            for p in range(8):
                if part[k][p] != chess1[k][p]:
                    diff1 += 1
        for k in range(8):
            for p in range(8):
                if part[k][p] != chess2[k][p]:
                    diff2 += 1
        diff = min(diff1, diff2)
        need_to_color = min(need_to_color, diff)
                    
print(need_to_color)
            