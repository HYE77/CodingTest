n = int(input())

print([0, 1][(n % 4 == 0) & ((n % 100 != 0) | (n % 400 == 0))])