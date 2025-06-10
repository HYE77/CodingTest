import sys
from collections import deque

n = int(input()) # num of test cases

for _ in range(n):
    N, M = map(int, input().split()) # N: num of papers | M: index of the paper
    numlist = list(map(int, input().split()))
    
    result = 1
    while numlist:
        if numlist[0] < max(numlist): # less important
            numlist.append(numlist.pop(0))
        else: # go print
            if M == 0: # if the target is in the very front
                break

            numlist.pop(0)
            result += 1

        M = M - 1 if M > 0 else len(numlist) - 1 # modify index of the target

    print(result)