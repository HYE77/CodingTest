def solution(n, m):
    if n > m:
        n, m = m, n # n <= m
        
    # 최소공배수 a
    a = 1
    for i in range(n, 0, -1):
        if n % i == 0 and m % i == 0:
            a = i
            break
    
    # 최대공약수 b
    for i in range(m, m*n + 1):
        if i % n == 0 and i % m == 0:
            b = i
            break
            
    return [a, b]