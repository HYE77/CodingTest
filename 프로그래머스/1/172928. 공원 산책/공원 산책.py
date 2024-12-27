def solution(park, routes):
    h = len(park) - 1 # 세로 한계
    w = len(park[0]) - 1 # 가로 한계
    
    # 시작점 찾기 (i, j)
    for _ in range(len(park)):
        if 'S' in park[_]:
            i = _
    for _ in range(len(park[i])):
        if park[i][_] == 'S':
            j = _
    
    # routes
    for route in routes:
        dirr= route.split()[0]
        step = int(route.split()[1])
        if dirr == 'E':
            if j + step > w or 'X' in park[i][j:j+step+1]:
                pass
            else:
                j += step
        elif dirr == 'W':
            if j - step < 0 or 'X' in park[i][j:j-step-1:-1]:
                pass
            else:
                j -= step
        elif dirr == 'N':
            if i - step < 0 or 'X' in [park[_][j] for _ in range(i, i-step-1, -1)]:
                pass
            else:
                i -= step
        else: #'S'
            if i + step > h or 'X' in [park[_][j] for _ in range(i, i+step+1)]:
                pass
            else:
                i += step
    
    
    return [i, j]