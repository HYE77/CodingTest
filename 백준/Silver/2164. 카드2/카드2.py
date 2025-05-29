import sys
from collections import deque
que = deque()
input = sys.stdin.readline

N = int(input())
for _ in range(1, N+1):
    que.append(_)

while len(que) > 1:
    que.popleft()
    if len(que) == 1:
        break
    else:
        temp = que.popleft()
        que.append(temp)

print(que[0])