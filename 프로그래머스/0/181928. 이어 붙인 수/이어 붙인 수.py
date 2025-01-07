def solution(num_list):
    odd = [str(n) for n in num_list if n % 2 == 0]
    even = [str(n) for n in num_list if n % 2 == 1]
    return int(''.join(odd)) + int(''.join(even))