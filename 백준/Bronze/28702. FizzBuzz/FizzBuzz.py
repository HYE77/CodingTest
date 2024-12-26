nlist = []
for i in range(0, 3):
    z = input()
    nlist.append(z)

for i in range(2, -1, -1):
    if nlist[i] in ['Fizz', 'Buzz', 'FizzBuzz']:
        pass
    else:
        numidx = i
        break

num = int(nlist[numidx])
if numidx == 2:
    next = num + 1
elif numidx == 1:
    next = num + 2
else:
    next = num + 3

if next % 3 == 0 and next % 5 == 0:
    print('FizzBuzz')
elif next % 3 == 0 and next % 5 != 0:
    print('Fizz')
elif next % 3 != 0 and next % 5 == 0:
    print('Buzz')
else:
    print(next)