N = int(input())
numlist = list(map(int, input().split()))
max_num = max(numlist)
nums = [n/ max_num*100 for n in numlist]
print(sum(nums)/len(nums))