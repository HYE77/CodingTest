import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    k = int(input()) # 층
    n = int(input()) # 호
    
    table = [[0] * 15 for _ in range(15)]
    
    for i in range(1, 15): # 0층
        table[0][i] = i

    for i in range(1, 15): # 1호 라인
        table[i][1] = 1

    for x in range(1, 15):
        for y in range(2, 15):
            table[x][y] = table[x][y-1] + table[x-1][y]

    print(table[k][n])
    

