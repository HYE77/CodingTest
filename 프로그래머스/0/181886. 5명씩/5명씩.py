def solution(names):
    return [name for i, name in enumerate(names) if i % 5 == 0]