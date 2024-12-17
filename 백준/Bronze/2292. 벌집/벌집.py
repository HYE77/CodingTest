floor = 1
house = 1
num = int(input())
while house < num:
    floor += 1
    house += (floor - 1) * 6
print(floor)