a, b, v = map(int, input().split())
import math

if v - a <= 0:
    print(1)
else:
    print(math.ceil((v - a) / (a - b)) + 1)