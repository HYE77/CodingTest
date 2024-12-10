r = []
for i in range(10):
    j = int(input())
    r.append(j%42)
print(len(set(r)))