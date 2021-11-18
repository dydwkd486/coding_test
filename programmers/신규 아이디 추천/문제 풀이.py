def solution(new_id):
    new_id= new_id.lower() # 1단계 소문자로 치환
    # print(new_id)
    name=[]
    for i in range(len(new_id)):
        if new_id[i] in "qwertyuiopasdfghjklzxcvbnm-_.1234567890": # 2단계
            name.append(new_id[i])
    # 3단계 
    i = 0
    while True:
        if i==len(name)-1:
            break
        if name[i]=="." and name[i]==name[i+1]:
            name.pop(i)
            i-=1
        i+=1
    
    # print("3단계:","".join(name))
    
    # 4단계
    if name[0]==".":
        name.pop(0)
    if len(name)!=0:
        if name[-1]==".":
            name.pop(-1)
        
    # print("4단계:","".join(name))
    # 5 단계
    if len(name)==0:
        name.append("a")
    
    # print("5단계:","".join(name))
    
    # 6단계
    if len(name)>=16:
        name=name[0:15]
        if name[-1]==".":
            name.pop(-1)
            
    # print(len(name))
    
    while True:
        if len(name)<3:
            name.append(name[-1])
        else:
            break
    
    # print("".join(name))
    
    answer = "".join(name)
    return answer

# 대문자는 소문자로 변경해야함.
#
