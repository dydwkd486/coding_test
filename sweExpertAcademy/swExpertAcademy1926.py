n = int(input())
result=[]
for i in range(1, n+1):
    # print()
    str_i = list(str(i))
    temp=""
    for j in str_i:
        if int(j)%3==0 and j!="0":
            temp += "-"
        else:
            temp += j
    if temp.count("-")>0:
        temp = "-"*temp.count("-")
    print(temp,end=" ")