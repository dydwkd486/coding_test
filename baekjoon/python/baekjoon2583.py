import sys
sys.setrecursionlimit(100000)
input=sys.stdin.readline

dx =[1,0,-1,0]
dy =[0,1,0,-1]

def dfs(x,y):
    global area
    if check[x][y]==True:
        area=area+1
        check[x][y]=False
        for i in range(4):
            temp_x=x+dx[i]
            temp_y=y+dy[i]
            if temp_x>=0 and temp_x<m and temp_y>=0 and temp_y<n:
                dfs(temp_x,temp_y)
    

        
    


m,n,k = map(int,input().split(" "))

count=0
check=[]
area_list=[]
area=0

for i in range(m):
    temp=[]
    for j in range(n):
        temp.append(True)
    check.append(temp)
# print(check)

for i in range(k):
    a_x,a_y,b_x,b_y=map(int,input().split(" "))
    for j in range(a_x,b_x,1):
        for k in range(a_y,b_y,1):
            check[k][j]=False

for i in range(m):
    for j in range(n):
        if check[i][j]==True:
            count=count+1
            dfs(i,j)
            area_list.append(area)
            area=0
area_list=sorted(area_list)
print(count)
print(' '.join(map(str,area_list)))
