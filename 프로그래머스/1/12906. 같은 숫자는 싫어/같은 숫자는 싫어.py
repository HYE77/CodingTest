def solution(arr):
    answer = []
    for _ in arr:
        if not answer or answer[-1] != _:
            answer.append(_)
    return answer