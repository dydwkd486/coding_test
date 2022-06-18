from collections import defaultdict
def solution(id_list, report, k):
    report_dict = defaultdict(int)
    id_dict=defaultdict(list)
    answer = []
    for i in set(report):
        temp = i.split()
        report_dict[temp[1]]+=1
        id_dict[temp[0]].append(temp[1])
        
    for i in id_list:
        temp =0
        for j in id_dict[i]:
            if k<=report_dict[j]:
                temp+=1
        answer.append(temp)

    return answer