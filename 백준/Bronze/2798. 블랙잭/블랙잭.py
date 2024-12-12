from itertools import combinations
N, M = map(int, input().split())
nums = list(map(int, input().split()))
ans = 0
for i in combinations(nums, 3):
    if sum(i) <= M:
        ans = max(ans, sum(i))
print(ans)