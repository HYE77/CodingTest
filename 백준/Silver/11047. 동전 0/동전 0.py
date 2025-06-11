import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
# N: num of coins
# K: goal amount of money

# make coin list
coins = []
for _ in range(N):
    c = int(input().rstrip())
    if c <= K:
        coins.append(c)
    else:
        break

count = 0
while K > 0:
    biggest = coins.pop()
    if K >= biggest:
        temp = K // biggest
        count += temp
        K -= (biggest * temp)
        
print(count)