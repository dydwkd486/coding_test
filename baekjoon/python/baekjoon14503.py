import sys
from collections import deque
dx=[-1,0,1,0]
dy=[0,1,0,-1]

input = sys.stdin.readline

n,m = list(map(int,input().split()))
r,c,d = list(map(int,input().split()))
visited=[]
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))
    visited.append([False for i in range(m)])

queue = deque()
queue.append([r,c])
visited[r][c]=True
result=1
while queue:
    v = queue.popleft()
    count=0
    for _ in range(4):
        nx =v[0]+dx[(d+3)%4]
        ny =v[1]+dy[(d+3)%4]
        d=(d+3)%4
        if -1<nx<n and -1<ny<m:
            if visited[nx][ny]==False and graph[nx][ny]==0:
                visited[nx][ny]=True
                result+=1
                queue.append([nx,ny])
                count=1
                break
    if count==0:
        nx =v[0]-dx[d]
        ny =v[1]-dy[d]
        if graph[nx][ny]!=1:
            queue.append([nx,ny])
        else:
            print(result)
            break

