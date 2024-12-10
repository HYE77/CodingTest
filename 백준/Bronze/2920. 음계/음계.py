K = input().split()
if sorted(K) == K:
    print('ascending')
elif sorted(K, reverse=True) == K:
    print('descending')
else:
    print('mixed')