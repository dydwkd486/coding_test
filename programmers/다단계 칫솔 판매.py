def solution(enroll, referral, seller, amount):    
    answer = [0 for i in range(len(enroll))]
    
    idex={name:idx for idx,name in enumerate(enroll)}
    
    # print(idex['mary'])
    for idx, name in enumerate(seller):   
        count=100*amount[idx] # 칫솔 개수 * 100 
        answer[idex[name]] += count
        while referral[idex[name]]!="-":
            answer[idex[name]]-=count//10
            name=referral[idex[name]]
            answer[idex[name]]+=count//10
            count=count//10
            
            if count==0:
                break
        if referral[idex[name]]=="-":
            answer[idex[name]]-=count//10
    return answer