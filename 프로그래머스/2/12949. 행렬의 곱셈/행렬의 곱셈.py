def solution(arr1, arr2):
    ans_rows = len(arr1) # 행
    ans_cols = len(arr2[0]) # 열
    
    answer = [[0] * ans_cols for _ in range(ans_rows)]
    
    for i in range(ans_rows): # 행
        for j in range(ans_cols): # 열  
            for k in range(len(arr2)): # 곱셈 순회 위한 k  
                answer[i][j] += arr1[i][k] * arr2[k][j]  
    
    return answer
