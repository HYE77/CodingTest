import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
heard = set()
seen = set()

for _ in range(N):
    name = input().rstrip()
    heard.add(name)
    
for _ in range(M):
    name = input().rstrip()
    seen.add(name)
    
both = sorted(list(heard & seen))
print(len(both))
for name in both:
    print(name)