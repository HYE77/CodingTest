str = input()
answer = ''
for _ in str:
    if _.isupper():
        answer += _.lower()
    else:
        answer += _.upper()
print(answer)