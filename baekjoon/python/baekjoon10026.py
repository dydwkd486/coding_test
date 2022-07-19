import sys
sys.setrecursionlimit(15000)

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x,y,color):
    if x<=-1 or x>=n or y<=-1 or y>=n:
        return False
    if visitd[x][y]==0 and graph[x][y]==color:
        visitd[x][y]=1
        for i in range(4):
            dfs(x+dx[i],y+dy[i],color)
        return True
    return False

def dfs_1(x,y,color):
    if x<=-1 or x>=n or y<=-1 or y>=n:
        return False
    if visitd[x][y]==0 and graph_1[x][y]==color:
        visitd[x][y]=1
        for i in range(4):
            dfs_1(x+dx[i],y+dy[i],color)
        return True
    return False

input = sys.stdin.readline

n = int(input())
visitd = [[0 for i in range(n)] for i in range(n)]
graph = []
graph_1 = []
count=0
count_1=0

for i in range(n):
    temp=list(input().strip())
    graph.append(temp)

for i in range(n):
    temp=[]
    for j in range(n):
        temp.append(graph[i][j].replace("G","R"))
    graph_1.append(temp)

for i in range(n):
    for j in range(n):
        if dfs(i,j,graph[i][j]):
            count+=1

visitd = [[0 for i in range(n)] for i in range(n)]
for i in range(n):
    for j in range(n):
        if dfs_1(i,j,graph_1[i][j]):
            count_1+=1
print(count,count_1)