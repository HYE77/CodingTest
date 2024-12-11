N = int(input())
ans = 0
start = max(1, N - 9 * len(str(N)))
for i in range(start, N):
    if i + sum([int(_) for _ in str(i)]) == N:
        ans = i
        break
print(ans)