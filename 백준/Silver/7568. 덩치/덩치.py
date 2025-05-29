import sys
input = sys.stdin.readline

N = int(input()) 
list = []
for _ in range(N):
    x, y = map(int, input().split())
    list.append([x, y])
    
ans = [1] * N
for i, (x, y) in enumerate(list):
    big = 0
    for _ in range(N):
        if i != _:
            if list[_][0] > x and list[_][1] > y:
                ans[i] += 1
                
print(' '.join(map(str, ans)))
            
    
        
