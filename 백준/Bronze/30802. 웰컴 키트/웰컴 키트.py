N = int(input())
size = list((map(int, input().split())))
T, P = map(int, input().split())

t_num = [(s-1)//T + 1 for s in size]
print(sum(t_num))
print(N//P, N%P)