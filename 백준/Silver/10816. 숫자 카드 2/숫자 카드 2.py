import sys
from collections import Counter

input = sys.stdin.readline

N = int(input())
total_list = list(map(int, input().split()))
nums_dict = Counter(total_list)

M = int(input())
search_list = list(map(int, input().split()))
ans_list = []

for n in search_list:
    ans_list.append(nums_dict[n])
    
ans = ' '.join(str(i) for i in ans_list)
print(ans)