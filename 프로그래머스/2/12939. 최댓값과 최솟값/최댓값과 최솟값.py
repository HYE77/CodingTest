def solution(s):
    numlist = list(map(int, s.split()))
    minn, maxn = min(numlist), max(numlist)
    return ' '.join([str(minn), str(maxn)])