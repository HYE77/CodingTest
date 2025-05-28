N = int(input())

number = 666

while True:
    if '666' in str(number):
        N -= 1
    if N == 0:
        print(number)
        break
    number += 1

