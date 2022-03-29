import sys
from collections import deque

dx=[1,-1,0,0]
dy=[0,0,1,-1]

input = sys.stdin.readline

n,l,r = list(map(int,input().split()))
graph =[]

for i in range(n):
    graph.append(list(map(int,input().split())))

result=0
while True:
    visited=[[False]*n for i in range(n)]
    total_count=0
    for i in range(n):
        for j in range(n):
            if visited[i][j]==False:
                visited[i][j]=True
                queue = deque([[i,j]])
                visited_list=[[i,j]]
                while queue:
                    x,y= queue.popleft()
                    for k in range(4):
                        nx = dx[k]+x
                        ny = dy[k]+y
                        if -1<nx<n and -1<ny<n:
                            if not visited[nx][ny]:
                                if l<=abs(graph[x][y]-graph[nx][ny])<=r:
                                    queue.append([nx,ny])
                                    visited[nx][ny]=True
                                    visited_list.append([nx,ny])
                if len(visited_list)>1:
                    total_count+=1
                    temp=sum([graph[x][y] for x, y in visited_list])//len(visited_list)
                    for x,y in visited_list:
                        graph[x][y]=temp
    if total_count:
        result+=1
    else:
        break
            # print(total,count,visited_list)
            # print(graph)
print(result)
