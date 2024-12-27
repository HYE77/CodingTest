def solution(lottos, win_nums):
    answer = [] # 최고, 최저
    same = 0 # 맞은 번호 개수
    for l in lottos:
        if l in win_nums:
            same += 1
    zeros = lottos.count(0)
    grade = [6, 6, 5, 4, 3, 2, 1]
    answer.append(grade[same + zeros])
    answer.append(grade[same])
    return answer