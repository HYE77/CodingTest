import sys
input = sys.stdin.readline

onethree = [1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1]

ISBN = input().rstrip()
target_index = ISBN.find('*') # index of *

ISBN = list(ISBN)
ISBN[target_index] = '99999'
ISBN_int = [int(n) for n in ISBN]
onethree[target_index] = 0

mul_sum = sum([onethree[i] * ISBN_int[i] for i in range(13)])

k = 1 if target_index % 2 == 0 else 3

res = mul_sum % 10
if res == 0:
    ans = 0
else:
    if k == 1:
        ans = 10 - res
    else:
        ans = 0
        while True:
            if (mul_sum + ans * 3) % 10 == 0:
                break
            else:
                ans += 1

print(ans)