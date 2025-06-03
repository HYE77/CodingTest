import sys

input = sys.stdin.readline

N = int(input())
nums = []
for _ in range(N):
    n = int(input())
    if n > 0: # not 0
        nums.append(n)
    else:
        nums.pop()
print(sum(nums))