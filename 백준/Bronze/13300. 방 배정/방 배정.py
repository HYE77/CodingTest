import sys, math
input = sys.stdin.readline

N, K = map(int, input().split())
dict = {i: [0, 0] for i in range(1, 7)}
for _ in range(N):
    sex, grade = map(int, input().rstrip().split())
    if sex == 0:
        dict[grade][0] += 1
    else:
        dict[grade][1] += 1

ans = 0
for g in range(1, 7):
    for s in range(2):
        room = math.ceil(dict[g][s] / K)
        ans += room
    

print(ans)