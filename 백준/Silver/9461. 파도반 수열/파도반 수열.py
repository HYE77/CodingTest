import sys
input = sys.stdin.readline

dp = [0] * 101

one2ten = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
for i in range(1, 11):
    dp[i] = one2ten[i-1]

# formula: df[N] = dp[N-1] + dp[N-5]
for k in range(11, 101):
    dp[k] = dp[k-1] + dp[k-5]

T = int(input()) # test case
for _ in range(T):
    n = int(input())
    print(dp[n])