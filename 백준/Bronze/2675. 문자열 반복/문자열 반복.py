N = int(input())
for i in range(N):
    M, string = input().split()
    for _ in string:
        print(_ * int(M), end = '')
    print()