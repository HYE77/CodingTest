import sys

input = sys.stdin.readline

while True:
    strings = input().rstrip()
    if strings == '.':
        break
    else:
        stack = []
        stop = 0

    for s in strings:
        if s in ['(', '[']: # open bracket
            stack.append(s)
        elif s in [')', ']']: # close bracket
            if not stack: # when stack is empty
                stop = 1
                print('no')
                break
            else:
                lastone = stack.pop()
                if (s == ')' and lastone == '(') or (s == ']' and lastone == '['): # correctly paired
                    continue
                else: # incorrectly paired
                    stop = 1
                    print('no')
                    break
    if stop == 0 and len(stack) > 0:
        print('no')
    elif stop == 0 and len(stack) == 0:
        print('yes')
    