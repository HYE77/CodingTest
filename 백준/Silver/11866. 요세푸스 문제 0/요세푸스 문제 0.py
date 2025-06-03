import sys
input = sys.stdin.readline

N, K = map(int, input().split()) 

nums = [i for i in range(1, N+1)]
anslist = []
i = K - 1 # rotating index (first i is starting point)

for _ in range(N):
      i = i % len(nums)
      target = nums[i]
      nums.remove(target)
      anslist.append(target)
      i += K - 1
      
ans = ', '.join(str(_) for _ in anslist)
print('<' + ans + '>')