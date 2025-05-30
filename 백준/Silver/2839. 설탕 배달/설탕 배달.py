import sys
input = sys.stdin.readline

N = int(input()) # kg

ans = []

for i in range(N//3 + 1):
    for j in range(N//3 + 1):
        if 5 * i + 3 * j == N:
            ans.append(i+j)

if not ans:
    print(-1)
else: print(min(ans))