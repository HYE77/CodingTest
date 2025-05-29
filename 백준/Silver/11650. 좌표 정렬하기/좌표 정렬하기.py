import sys
input = sys.stdin.readline

N = int(input())
list = []
for _ in range(N):
    x, y = map(int, input().split())
    list.append([x, y])
    
ans = sorted(list, key = lambda x: (x[0], x[1]))

for _ in ans:
    print(' '.join(map(str, _)))