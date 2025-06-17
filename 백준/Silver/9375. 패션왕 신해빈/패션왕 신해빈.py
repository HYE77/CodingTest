import sys
input = sys.stdin.readline

T = int(input()) # test case
for _ in range(T): 
    n = int(input()) # num of kinds of cloths
    # make closet dictionary
    closet = {}
    for k in range(n):
        name, kind = input().rstrip().split()
        if kind in closet:
            closet[kind].append(name)
        else:
            closet[kind] = [name]
    # calculate cases
    ans = 1
    for k, v in closet.items():
        ans *= (len(v) + 1)
    
    print(ans-1)