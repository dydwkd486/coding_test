def req(m,temp):
    result=0
    if temp==m:
        return 1
    elif temp>m:
        return 0
    else:
        result += req(m,temp+1)
        result += req(m, temp + 2)
        result += req(m, temp + 3)
    return result

n=int(input())

for i in range(n):
    result=0
    temp=0
    m=int(input())
    result=req(m,temp)
    print(result)