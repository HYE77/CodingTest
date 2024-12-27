def solution(s):
    x = len(s)
    if x % 2 == 1:
        return 0
    
    def check(s):
        stack = []
        for i in range(len(s)):
            if s[i] in ['(', '[', '{']:
                stack.append(s[i])
            elif s[i] == ')':
                if stack:
                    if stack.pop() == '(':
                        continue
                    else:
                        return False
                else:
                    return False
            elif s[i] == '}':
                if stack:
                    if stack.pop() == '{':
                        continue
                    else:
                        return False
                else:
                    return False
            elif s[i] == ']':
                if stack:
                    if stack.pop() == '[':
                        continue
                    else:
                        return False   
                else:
                    return False
        return True
        
    answer = 0
    
    for i in range(x):
        rotated = s[i:] + s[:i+1]
        if check(rotated):
            answer += 1
    return answer