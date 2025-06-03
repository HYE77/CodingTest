import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

queue = deque()

for _ in range(N):
    request = list(input().split())
    if request[0] == 'push':
        queue.append(int(request[1]))
    elif request[0] == 'pop':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif request[0] == 'size':
        print(len(queue))
    elif request[0] == 'empty':
        print(1 if len(queue) == 0 else 0)
    elif request[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    elif request[0] == 'back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])
