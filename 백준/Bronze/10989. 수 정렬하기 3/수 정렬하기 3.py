import sys

N = int(input())

count = [0] * 10001

for _ in range(N):
    num = int(sys.stdin.readline())
    count[num] += 1

for i in range(1, 10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)