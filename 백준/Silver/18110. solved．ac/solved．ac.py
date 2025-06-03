import sys
input = sys.stdin.readline

def custom_round(n):
    return int(n // 1 + (1 if n % 1 >= 0.5 else 0))

n = int(input())

grades = []
for _ in range(n):
    grade = int(input())
    grades.append(grade)
    
grades.sort()

if n == 0:
    print(0)
elif len(grades) <= 3:
    print(custom_round(sum(grades)/len(grades)))
else:
    cutline = custom_round(n * 0.15)
    selected = grades[cutline:-cutline]
    print(custom_round(sum(selected)/len(selected)))