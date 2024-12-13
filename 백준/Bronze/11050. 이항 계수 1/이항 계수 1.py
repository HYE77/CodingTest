N, K = map(int, input().split())
import math
print(int(math.factorial(N)/(math.factorial(K)*math.factorial(N-K))))