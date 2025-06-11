import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

# make pokemon dictionary
pokemon = {}
for i in range(N):
    name = input().rstrip()
    pokemon[i+1] = name
    pokemon[name] = i+1 
    
# test
for _ in range(M):
    quiz = input().rstrip()
    if quiz.isnumeric():
        print(pokemon[int(quiz)])
    else:
        print(pokemon[quiz])