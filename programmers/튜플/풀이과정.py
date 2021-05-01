from collections import Counter

def solution(s):
    answer = []
    s=s[2:-2].split("},{")
    s_list=[]
    for i in s:
        for j in i.split(","):
            s_list.append(int(j))
    for i in Counter(s_list).most_common():
        answer.append(i[0])
    return answer
