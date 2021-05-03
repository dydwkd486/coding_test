#bfs 문제
from collections import deque
from sys import stdin

def bfs(graph, start):
    queue = deque(start)
    # print(start)
    while queue:
        x,y= queue.popleft()
        # print(x,y)
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if graph[nx][ny]==-1:
                continue
            if graph[nx][ny]==0:
                graph[nx][ny]= graph[x][y]+1
                queue.append((nx,ny))
    max=-1
    for i in graph:
        for j in i:
            if j==0:
                return -1
            elif max<j:
                max=j
    return max-1



M,N = list(map(int,stdin.readline().split()))
dx=[0,0,1,-1]
dy=[1,-1,0,0]
graph=[]
start=[]
for _ in range(N):
    graph.append(list(map(int,stdin.readline().split())))

# print(M,N)
# print(graph)
for i in range(N):
    for j in range(M):
        x=graph[i][j]
        if x==1:
            start.append([i,j])
result=bfs(graph,start)

print(result)