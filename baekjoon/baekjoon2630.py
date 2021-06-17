import sys

def Recursion(result, x,y,n,count):
    n_clone=n
    result_clone=result
    if n_clone==1:
        if result_clone[x][y]==0:
            count[0]+=1
        else:
            count[1]+=1
        return
    else:
        temp=0
        for i in range(n_clone):
            for j in range(n_clone):
                temp+=result_clone[x+i][y+j]
        if temp==n*n:
            count[1]+=1
        elif temp==0:
            count[0]+=1
        else:
            Recursion(result_clone,x,y,int(n/2),count)
            Recursion(result_clone,x+int(n/2),y,int(n/2),count)
            Recursion(result_clone,x,y+int(n/2),int(n/2),count)
            Recursion(result_clone,x+int(n/2),y+int(n/2),int(n/2),count)

result=[]
count=[0,0]
n= int(input())
for i in range(n):
    result.append(list(map(int,sys.stdin.readline().split())))
# print(result)

Recursion(result,0,0,n,count)
print(count[0])
print(count[1])
