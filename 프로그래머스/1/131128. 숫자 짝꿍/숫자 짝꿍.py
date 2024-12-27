def solution(X, Y):
    if len(set(X)) > len(set(Y)):
         X, Y = Y, X # X < Y
    
    numlist = []
    x_dict = {k : X.count(k) for k in set(X)}
    y_dict = {k : Y.count(k) for k in set(Y)}
                         
    for x_key in x_dict:
        if x_key in y_dict:
            many = min(x_dict[x_key], y_dict[x_key])
            for i in range(many):
                numlist.append(int(x_key))
    
    if len(numlist) == 0:
        return "-1"
    elif sum(numlist) == 0:
        return "0"
    else: 
        numlist.sort(reverse = True)
        numlist = [str(i) for i in numlist]
        return ''.join(numlist)
    