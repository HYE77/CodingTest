def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        arr2 = arr[s:e+1]
        nums = [num for num in arr2 if num > k]
        min_n = min(nums) if len(nums) > 0 else -1
        answer.append(min_n)
    return answer