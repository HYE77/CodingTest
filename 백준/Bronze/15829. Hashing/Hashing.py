L = int(input())
list = list(input())
# ord(_) - 96
ans = 0
for i in range(L):
    ans += ((ord(list[i]) - 96) * (31 ** i))
print(ans % 1234567891)
