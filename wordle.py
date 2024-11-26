import random
import numpy as np
words = [
    "airplane",
    "apple",
    "arm",
    "bakery",
    "banana",
    "bank",
    "bean",
    "belt",
    "bicycle",
    "biography",
    "blackboard",
    "boat",
    "bowl",
    "broccoli",
    "bus",
    "car",
    "carrot",
    "chair",
    "cherry",
    "cinema",
    "class",
    "classroom",
    "cloud",
    "coat",
    "cucumber",
    "desk",
    "dictionary",
    "dress",
    "ear",
    "eye",
    "fog",
    "foot",
    "fork",
    "fruits",
    "hail",
    "hand",
    "head",
    "helicopter",
    "hospital",
    "ice",
    "jacket",
    "kettle",
    "knife",
    "leg",
    "lettuce",
    "library",
    "magazine",
    "mango",
    "melon",
    "motorcycle",
    "mouth",
    "newspaper",
    "nose",
    "notebook",
    "novel",
    "onion",
    "orange",
    "peach",
    "pharmacy",
    "pineapple",
    "plate",
    "pot",
    "potato",
    "rain",
    "shirt",
    "shoe",
    "shop",
    "sink",
    "skateboard",
    "ski",
    "skirt",
    "sky",
    "snow",
    "sock",
    "spinach",
    "spoon",
    "stationary",
    "stomach",
    "strawberry",
    "student",
    "sun",
    "supermarket",
    "sweater",
    "teacher",
    "thunderstorm",
    "tomato",
    "trousers",
    "truck",
    "vegetables",
    "vehicles",
    "watermelon",
    "wind"
]

answer = random.choice(words)
answer_list = [i for i in answer]
print(f'이 단어는 {len(answer)} 자리입니다.')

now = '*' * len(answer)

chance = 1
while chance < 10: # 정답을 맞췄거나, 기회를 다 쓰면 종료.
    print(now)
    quiz_try = input(f'{chance}번째 시도. 알파벳을 입력하세요.')
    if quiz_try in answer: # 단어 안에 있는 글자 맞춤.
        ans_array = np.array(answer_list)

        answer_list = list(answer.replace(quiz_try, '*'))
        a_index = np.where(ans_array == quiz_try)[0] # 맞춘 알파벳이 있는 위치
        for i in a_index:
            now_list = list(now)
            now_list[i] = quiz_try
            now = ''.join(now_list)
        if now == answer:
            print('정답입니다. 게임 종료.')
            break
        print(f'{quiz_try}가 단어에 있습니다. 현재 정답 상황: {now} \n 남은 기회: {9 - chance}')
    else:
        print(f'{quiz_try}는(은) 정답 단어에 없습니다.\n 현재 남은 기회: {9 - chance}')
    chance += 1

if now != answer:
    print('기회를 모두 소진했습니다.')