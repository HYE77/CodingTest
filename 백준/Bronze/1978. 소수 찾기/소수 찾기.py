N = int(input())
num = list(map(int, input().split()))
ans = 0
for i in num:
    dev = 0
    for j in range(1, int(i ** 0.5) + 1):
        if i % j == 0:
            dev += 1
            if j ** 2 != i:
                dev += 1
    if dev == 2:
        ans += 1
print(ans)