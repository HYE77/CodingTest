import sys
input = sys.stdin.readline

n = int(input()) # 컴퓨터 개수
v = int(input()) # 연결선 개수

# 그래프 생성
graph = [[] for i in range(n + 1)] # 그래프 초기화
visited = [0] * (n + 1) # 방문한 컴퓨터인지 표시
for i in range(v): # 그래프 생성
    a, b = map(int, input().rstrip().split())
    graph[a] += [b] # a에 b 연결
    graph[b] += [a] # b에 a 연결 -> 양방향

# 탐색
def dfs(v):
    visited[v] = 1
    for nx in graph[v]:
        if visited[nx] == 0:
            dfs(nx)

dfs(1)
print(sum(visited) - 1)
