import sys
input = sys.stdin.readline

n = int(input())
list_n = [list(map(int,input().split())) for i in range(n)]

count = [0,0,0]

def div(size,x,y):
    temp=[0,0,0]
    for i in range(size):
        for j in range(size):
            if list_n[i+x][j+y]==-1:
                temp[0]+=1
            elif list_n[i+x][j+y]==0:
                temp[1]+=1
            else:
                temp[2]+=1
    if max(temp)==size**2:
        count[temp.index(max(temp))]+=1
    elif size==3:
        for i in range(3):
            count[i]+=temp[i]
    else:
        for i in range(0,size,size//3):
            # print(i)
            for j in range(0,size,size//3):
                div(size//3,i+x,j+y)
    
div(n,0,0)
for i in range(3):
    print(count[i])