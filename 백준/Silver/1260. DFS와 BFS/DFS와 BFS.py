import sys
input = sys.stdin.readline

N, M, V = map(int, input().rstrip().split()) # node, edge, start node
tree = [[] for _ in range(N+1)]
visited = [False for _ in range(N+1)]
dfs_result = []
bfs_result = []

for _ in range(M):
    a, b = map(int, input().rstrip().split())
    tree[a] += [b]
    tree[b] += [a]
    
for t in tree:
    t.sort()

def dfs(start):
    visited[start] = True
    dfs_result.append(str(start))
    for node in tree[start]:
        if visited[node] == False:
            dfs(node)
dfs(V)
ans = ' '.join(dfs_result)


from collections import deque
visited = [False for _ in range(N+1)]
def bfs(start):
    visited[start] = True 
    bfs_result.append(str(start))
    Q = deque([start]) 
    while Q:
        node = Q.popleft()
        for nx in tree[node]:
            if visited[nx] == False:
                Q.append(nx)
                visited[nx] = True
                bfs_result.append(str(nx))

bfs(V)
ans2 = ' '.join(bfs_result)

print(ans)
print(ans2)

