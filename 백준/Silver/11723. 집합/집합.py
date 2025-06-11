import sys
input = sys.stdin.readline

S = set()

def set_add(s, x):
    s.add(x)

def set_remove(s, x):
    if x in s:
        s.remove(x)
    
def set_check(s, x):
    print(int(x in s))
    
def set_toggle(s, x):
    if x in s:
        s.remove(x)
    else:
        s.add(x)
    
def set_all(s):
    s = set(i for i in range(1, 21))
    return s
    
def set_empty(s):
    s = set()
    return s


M = int(input().rstrip())
for _ in range(M):
    request = input().rstrip().split()
    if request[0] == 'add':
        set_add(S, int(request[1]))
    elif request[0] == 'remove':
        set_remove(S, int(request[1]))
    elif request[0] == 'check':
        set_check(S, int(request[1]))
    elif request[0] == 'toggle':
        set_toggle(S, int(request[1]))
    elif request[0] == 'all':
        S = set_all(S)
    else:
        S = set_empty(S)