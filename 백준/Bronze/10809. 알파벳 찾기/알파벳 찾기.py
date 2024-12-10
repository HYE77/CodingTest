dict = {k : -1 for k in range(97, 123)}
s = input()
for _ in s:
    if dict[ord(_)] == -1:
        dict[ord(_)] = s.index(_)
print(' '.join(str(v) for v in dict.values()))