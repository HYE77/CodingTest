import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(a, b):
    visited[(a, b)] = 1
    for c, d in graph[(a, b)]:
        if visited[(c, d)] == 0:
            dfs(c, d)

T = int(input()) # num of test cases
for _ in range(T):
    M, N, K = map(int, input().rstrip().split())  # 가로(M), 세로(N), 배추 개수

    # make farm
    farm = [[0] * M for _ in range(N)]
    cabbages = []
    for _ in range(K):
        x, y = map(int, input().rstrip().split())  # x = col, y = row
        farm[y][x] = 1
        cabbages.append((x, y))  # (col, row)

    # make graph
    graph = {(x, y): [] for y in range(N) for x in range(M)}  # 일관된 (x, y) 순서
    for y in range(N):
        for x in range(M):
            if farm[y][x] == 1:
                if y > 0 and farm[y-1][x] == 1:
                    graph[(x, y)].append((x, y-1))
                    graph[(x, y-1)].append((x, y))
                if y < N-1 and farm[y+1][x] == 1:
                    graph[(x, y)].append((x, y+1))
                    graph[(x, y+1)].append((x, y))
                if x > 0 and farm[y][x-1] == 1:
                    graph[(x, y)].append((x-1, y))
                    graph[(x-1, y)].append((x, y))
                if x < M-1 and farm[y][x+1] == 1:
                    graph[(x, y)].append((x+1, y))
                    graph[(x+1, y)].append((x, y))

    # search
    visited = {(x, y): 0 for y in range(N) for x in range(M)}

    count = 0
    for x, y in cabbages:
        if visited[(x, y)] == 0:
            dfs(x, y)
            count += 1

    print(count)
