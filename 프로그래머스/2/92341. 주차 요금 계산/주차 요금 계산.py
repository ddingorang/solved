from collections import defaultdict
from datetime import datetime
import math

def solution(fees, records):
    rc = defaultdict(str)
    acctime = defaultdict(int)
    answer = defaultdict(int)
    remaining = []
    for r in records:
        rsp = r.split(' ')
        if rsp[2] == 'IN':
            rc[rsp[1]] = rsp[0]
            remaining.append(rsp[1])
        elif rsp[2] == 'OUT' :
            if rc[rsp[1]] :
                fin = datetime.strptime(rsp[0], "%H:%M")
                start = datetime.strptime(rc[rsp[1]], "%H:%M")
                diff = fin - start
                diffmin = diff.seconds // 60
                acctime[rsp[1]] += diffmin
                remaining.remove(rsp[1])
    
    for r in remaining:
        fin = datetime.strptime("23:59", "%H:%M")
        start = datetime.strptime(rc[r], "%H:%M")
        diff = fin - start
        diffmin = diff.seconds // 60
        acctime[r] += diffmin
            
    sortedacctime = dict(sorted(acctime.items()))
    for carnum, acct in sortedacctime.items():
        if acct <= fees[0]:
            answer[carnum] += fees[1]
        else :
            answer[carnum] += fees[1] + (math.ceil((acct - fees[0]) / fees[2])) * fees[3]
    
    return list(answer.values())