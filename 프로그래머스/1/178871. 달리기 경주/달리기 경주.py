def solution(players, callings):
    p_dict = {p: i for i, p in enumerate(players)} # player : index
    i_dict = {i: p for i, p in enumerate(players)} # index : player
    
    for call in callings:
        called_index = p_dict[call] # index
        player2_name = i_dict[called_index - 1] # name
        i_dict[called_index], i_dict[called_index - 1] = i_dict[called_index - 1], i_dict[called_index]
        p_dict[call], p_dict[player2_name] = p_dict[player2_name], p_dict[call]
    sorted_dict = sorted(i_dict.items(), key = lambda item: item[0])
    ans = [tup[1] for tup in sorted_dict]
    return ans