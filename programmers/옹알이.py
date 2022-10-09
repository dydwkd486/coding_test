temp = ["aya", "ye", "woo", "ma"]
answer = 0
def check(num,temp1):
    global temp,answer
    print(temp1)
    if temp1 == "":
        answer +=1
    for i in range(len(temp)):
        if i==num:
            continue
        if temp[i]==temp1[:len(temp[i])]:
            check(i,temp1[len(temp[i]):])
    
    return
def solution(babbling):
    for babble in babbling:
        for i in range(len(temp)):
            if temp[i]==babble[:len(temp[i])]:
                check(i,babble[len(temp[i]):])
    return answer
