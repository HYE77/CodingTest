import sys
input = sys.stdin.readline

N = int(input().rstrip())
times = list(map(int, input().rstrip().split()))
reversed = sorted(times, reverse = True)
temp = [(i+1) * reversed[i] for i in range(len(reversed))]
print(sum(temp))