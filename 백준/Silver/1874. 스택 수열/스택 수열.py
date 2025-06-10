import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
target = deque() # list we aim to make
for _ in range(n):
    t = int(input())
    target.append(t)
    
inputs = deque()
for _ in range(1, n+1):
    inputs.append(_)

ans = ''
temp = []

while temp or inputs:
    if temp and (temp[-1] == target[0]):
        temp.pop()
        target.popleft()
        ans += '-'
    else:
        if inputs:
            num = inputs.popleft()
            if num != target[0]:
                temp.append(num)
                ans += '+'
            else: # find the target number
                ans += '+-'
                target.popleft()
        else:
            break
    
if not temp and not target:
    for _ in ans:
        print(_)
else:
    print('NO')