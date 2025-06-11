import sys
from collections import Counter
input = sys.stdin.readline

numlist = []
N = int(input().rstrip())
for _ in range(N):
    numlist.append(int(input().rstrip()))
    
def get_avg(list):
    return int(round(sum(list) / len(list), 0)) if len(list) > 0 else 0

def get_median(list):
    if len(list) % 2 == 1:
        return sorted(list)[len(list)//2]
    else:
        return (sorted(list)[len(list)//2] + sorted(list)[len(list)//2 -1]) / 2

def get_freq(list):
    counter = Counter(list)
    max_freq = max(counter.values())
    max_freq_list = [k for k, v in dict(counter).items() if v == max_freq]
    if len(max_freq_list) == 1:
        return max_freq_list[0]
    else:
        return sorted(max_freq_list)[1]
    
def get_range(list):
    return max(list) - min(list)

print(get_avg(numlist))
print(get_median(numlist))
print(get_freq(numlist))
print(get_range(numlist))