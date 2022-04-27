import sys
from collections import deque
input= sys.stdin.readline

nx=[0,0,1,-1]
ny=[1,-1,0,0]

n,m = map(int,input().split())
graph=[]
result=0

for i in range(n):
    temp = list(map(int,input().split()))
    graph.append(temp)

while True:
    count=0
    for i in graph:
        count+=sum(i)
    if count==0:
        break
    visited=[[False]*m for _ in range(n)]
    graph_1=[[0]*m for _ in range(n)]
    visited[0][0]=True
    queue = deque()
    queue.append([0,0])
    # print(visited)
    while queue:
        v= queue.popleft()
        # print(v[0],v[1])
        for i in range(4):
            dx=v[0]+nx[i]
            dy=v[1]+ny[i]
            if -1<dx<n and -1<dy<m:
                if graph[dx][dy]==1:
                    graph_1[dx][dy]+=1
                if graph[dx][dy]==0 and visited[dx][dy]==False:
                    visited[dx][dy]=True
                    queue.append([dx,dy])
    for i in range(n):
        for j in range(m):
            if graph_1[i][j]>=2:
                graph[i][j]=0
    
    result+=1
    count=0
    for i in graph:
        count+=sum(i)
    if count==0:
        break
print(result)