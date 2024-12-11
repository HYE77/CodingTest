def solution(survey, choices):
    dict = {k : 0 for k in 'RTFCMJAN'}
    for i in range(len(choices)):
        if choices[i] >= 5:
            dict[survey[i][1]] += choices[i] - 4
        elif choices[i] <= 3:
            dict[survey[i][0]] += 4 - choices[i]
    
    answer = ''

    answer += 'R' if dict['R'] >= dict['T'] else 'T'
    answer += 'C' if dict['C'] >= dict['F'] else 'F'
    answer += 'J' if dict['J'] >= dict['M'] else 'M'
    answer += 'A' if dict['A'] >= dict['N'] else 'N'
    
    return answer