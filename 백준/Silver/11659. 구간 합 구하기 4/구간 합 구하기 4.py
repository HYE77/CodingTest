import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

num = list(map(int, input().rstrip().split()))

cumsum = [0] * (N+1)
cumsum[1] = num[0]
for i in range(2, N+1):
    cumsum[i] = cumsum[i-1] + num[i-1]
    
for _ in range(M):
    i, j = map(int, input().rstrip().split())
    print(cumsum[j] - cumsum[i-1])