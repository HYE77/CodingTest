def solution(id_list, report, k):
    reported_id = {id:[] for id in id_list}
    report_id = {id:0 for id in id_list}
    
    for r in report:
        rep, reported = r.split()
        reported_id[reported].append(rep)
        
    for id in reported_id.keys():
        if len(set(reported_id[id])) >= k:
            for _ in set(reported_id[id]):
                report_id[_] += 1
            
    return list(report_id.values())