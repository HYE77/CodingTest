n = int(input())
for i in range(n):
    h, w, c = map(int, input().split())
    floor = c % h if c % h != 0 else h
    hor = c // h if c % h == 0 else c // h + 1
    if hor < 10:
        hor = '0' + str(hor)
    else:
        hor = str(hor)
    print(str(floor)+hor)