def solution(nums):
    set_nums = set(nums)
    if len(set_nums) >= len(nums) / 2:
        return int(len(nums)/2)
    else:
        return len(set_nums)