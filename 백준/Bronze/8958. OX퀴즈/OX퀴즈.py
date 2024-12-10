N = int(input())
for i in range(N):
    ans = input().split('X')
    ans = [a for a in ans if a !='']
    print(int(sum([len(a)*(len(a) + 1)/2 for a in ans])))