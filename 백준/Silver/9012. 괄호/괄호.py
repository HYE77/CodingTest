import sys
input = sys.stdin.readline

N = int(input())
for _ in range(N):
    strings = input().rstrip()
    stack = []
    valid = True
    for s in strings:
        if s == '(':
            stack.append(s)
        else:
            if not stack: # if stack is empty
                valid = False
                print('NO')
                break
            else:
                lastone = stack.pop()
                if lastone != '(':
                    valid = False
                    print('NO')
                    break
    if valid == True and not stack:
        print('YES')
    elif valid == True and stack:
        print('NO')