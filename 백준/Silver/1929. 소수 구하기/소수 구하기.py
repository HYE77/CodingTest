import sys
input = sys.stdin.readline

M, N = map(int, input().split())

a = [False, False] + [True] * (N-1)
primes=[]

for i in range(2, N+1):
  if a[i]:
    primes.append(i)
    for j in range(2*i, N+1, i):
        a[j] = False
        
for _ in primes:
    if _ >= M:
        print(_)

