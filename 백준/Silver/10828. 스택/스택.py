import sys
input = sys.stdin.readline

def push(stack, s):
    stack.append(s)

def size(stack):
    print(len(stack))

def empty(stack):
    print(1 if len(stack) == 0 else 0)

def pop(stack):
    if len(stack) == 0:
        print(-1)
    else:
        print(stack.pop())

def top(stack):
    if len(stack) == 0:
        print(-1)
    else:
        print(stack[-1])
        
N = int(input())
stack = []

for _ in range(N):
    request = list(input().split())
    if request[0] == 'push':
        push(stack, int(request[1]))
    elif request[0] == 'size':
        size(stack)
    elif request[0] == 'pop':
        pop(stack)
    elif request[0] == 'top':
        top(stack)
    elif request[0] == 'empty':
        empty(stack)        