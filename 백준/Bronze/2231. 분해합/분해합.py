N = int(input())
ans = 0
for i in range(N):
    if i + sum([int(_) for _ in str(i)]) == N:
        ans = i
        break
print(ans)