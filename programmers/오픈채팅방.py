def solution(record):
    userId={}
    answer = []
    for i in record:
        temp=i.split(" ")
        if temp[0]!="Leave":
            userId.update({temp[1]:temp[2]})
    for i in record:
        temp=i.split(" ")
        if temp[0]=="Enter":
            answer.append(userId[temp[1]]+"님이 들어왔습니다.")
        if temp[0]=="Leave":
            answer.append(userId[temp[1]]+"님이 나갔습니다.")
    return answer