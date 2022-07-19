import sys
sys.setrecursionlimit(15000)

def dfs(x,y):
    if x<=-1 or x>=n or y<=-1 or y>=n:
        return False
    if list_temp[x][y]==0:
        list_temp[x][y]=1
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False


input = sys.stdin.readline

n = int(input())
list_n=[]
for i in range(n):
    list_n.append(list(map(int,input().split())))

result_list=[]
for k in range(1,100):
    list_temp=[]
    result=0
    for i in range(n):
        temp=[]
        for j in range(n):
            if list_n[i][j]>=k:
                temp.append(0)
            else:
                temp.append(1)
        list_temp.append(temp)
    for i in range(n):
        for j in range(n):
            if dfs(i,j)==True:
                result+=1
    result_list.append(result)

print(max(result_list))