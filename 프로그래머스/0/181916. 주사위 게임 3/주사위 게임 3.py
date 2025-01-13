def solution(a, b, c, d):
    nums = sorted([a, b, c, d])
    if len(set(nums)) == 1:
        return 1111 * a
    elif len(set(nums)) == 4:
        return min(nums)
    elif len(set(nums)) == 2 and nums[1] != nums[2]:
        return (nums[0] + nums[-1]) * abs(nums[0] - nums[-1])
    elif len(set(nums)) == 2 and nums[1] == nums[2]:
        if nums[0] == nums[2]:
            return (10 * nums[0] + nums[-1]) ** 2
        else:
            return (10 * nums[2] + nums[0]) ** 2
    else:
        if nums[0] == nums[1]:
            return nums[2] * nums[3]
        elif nums[2] == nums[3]:
            return nums[0] * nums[1]
        else:
            return nums[0] * nums[-1]