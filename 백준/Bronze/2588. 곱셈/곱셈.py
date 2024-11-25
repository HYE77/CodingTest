num1 = int(input())
num2 = input()
for i in range(2, -1, -1):
    print(int(num2[i]) * num1)
print(num1 * int(num2))