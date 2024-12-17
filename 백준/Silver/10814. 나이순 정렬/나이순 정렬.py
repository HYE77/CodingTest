import sys
N = int(input())
members = []
for i in range(N):
    age, name = sys.stdin.readline().split()
    members.append([int(age), name])
members.sort(key = lambda x: x[0])
for k in members:
    print(str(k[0]) + ' ' + k[1])