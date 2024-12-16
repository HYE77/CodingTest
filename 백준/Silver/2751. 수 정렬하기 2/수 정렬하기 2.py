import sys
N = int(input())
nlist = []
for i in range(N):
    nlist.append(int(sys.stdin.readline()))
nlist.sort()
for n in nlist:
    print(n)