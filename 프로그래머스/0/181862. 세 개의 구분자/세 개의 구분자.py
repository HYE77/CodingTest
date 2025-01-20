def solution(myStr):
    myStr = myStr.replace('b', 'a')
    myStr = myStr.replace('c', 'a')
    ans = [i for i in myStr.split('a') if i != '']
    return ans if len(ans) != 0 else ['EMPTY']