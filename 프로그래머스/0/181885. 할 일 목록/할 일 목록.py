def solution(todo_list, finished):
    return [todo for todo, fini in zip(todo_list, finished) if fini == False]