import sys
input = sys.stdin.readline

N = int(input())
numlist = set(map(int, input().split()))
M = int(input())
findlist = list(map(int, input().split()))

for _ in findlist:
    if _ in numlist:
        print(1)
    else:
        print(0)