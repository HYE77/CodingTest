def solution(s):
    count = 0
    Done = False
    
    while Done == False:
        x = s[0]
        yes = 0 # x랑 같은 거
        no = 0 # x랑 다른 거
        
        for i in range(len(s)):
            if s[i] == x:
                yes += 1
            else:
                no += 1
            if yes == no: # for문 종료 - 분리 조건
                if yes+no == len(s):
                    count += 1
                    Done = True
                    break
                else:
                    s = s[yes+no:]
                    count += 1
                    break
            elif yes != no and i == len(s) - 1:
                count += 1
                Done = True
        
    
    return count