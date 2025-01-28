def solution(wallet, bill):
    answer = 0
    while True:
        wallet.sort()
        bill.sort()
        if bill[0] <= wallet[0] and bill[1] <= wallet[1]:
            return answer
        else:
            bill.append(bill.pop()//2)
            answer += 1
    return answer