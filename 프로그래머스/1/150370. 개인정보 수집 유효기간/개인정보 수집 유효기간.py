def solution(today, terms, privacies):
    import datetime as dt
    # terms를 딕셔너리로 만들기
    terms_dict = {}
    for term in terms:
        alpha, months = term.split(' ')
        terms_dict[alpha] = int(months)
    
    answer = []
    today = dt.datetime.strptime(today, '%Y.%m.%d')
    for i in range(len(privacies)):
        col_date = privacies[i][0:10]
        y, m, d = map(int, col_date.split('.'))
        term = privacies[i][-1]
        term_month = terms_dict[term] # 유효기간 몇 개월?
        add_y = term_month // 12 # n년
        add_m = term_month % 12 # n개월
        end_y, end_m, end_d = y + add_y, m + add_m, d - 1 # 수집 날짜에 유효기간 더해
        if end_m > 12:
            end_y += 1
            end_m -= 12
        if end_d == 0:
            end_m -= 1
            end_d = 28
            if end_m == 0:
                end_y -= 1
                end_m = 12
            
        end_ymd = '.'.join([str(end_y), str(end_m), str(end_d)])
        end_date = dt.datetime.strptime(end_ymd, '%Y.%m.%d')
        if end_date < today:
            answer.append(i+1)
    
    return answer