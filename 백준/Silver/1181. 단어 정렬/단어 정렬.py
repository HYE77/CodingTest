N = int(input())
words = []
i = 0
while i < N:
    words.append(input())
    i += 1
words = list(set(words))
ans = sorted(words, key = lambda x: (len(x), x))
for w in ans:
    print(w)