n = int(input())
result=[]
for i in range(1, n+1):
    temp=input()
    for j in range(1,min(11,len(temp))):
        # print(temp.replace(temp[:j],""))
        if temp[:j]==temp[j:j+j]:
            print(f"#{i} {j}")
            break