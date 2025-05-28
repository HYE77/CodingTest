import math

N = int(input())
result = str(math.factorial(N))[::-1]
ans = 0
for _ in result:
    if _ == '0':
        ans += 1
    else:
        print(ans)
        break
