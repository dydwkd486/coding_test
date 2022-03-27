# DFS
import sys
sys.setrecursionlimit(1000000)

def dfs(x,y):
    global count
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    elif graph[x][y]==1:
        count+=1
        graph[x][y]=0
        for i in range(4):
            dfs(x+dx[i],y+dy[i])
        return True
    return False

dx=[-1,1,0,0]
dy=[0,0,-1,1]

input = sys.stdin.readline

n,m = list(map(int,input().split()))

graph=[list(map(int,input().split())) for _ in range(n)]
result_count=0
max_count=[0]
count=0

for i in range(n):
    for j in range(m):
        count=0
        if dfs(i,j):
            result_count+=1
            max_count.append(count)

print(result_count)
print(max(max_count))

# bfs
from collections import deque
import sys

dx=[-1,1,0,0]
dy=[0,0,-1,1]

input = sys.stdin.readline

n,m = list(map(int,input().split()))

graph=[list(map(int,input().split())) for _ in range(n)]
result_count=0
max_count=[]


for i in range(n):
    for j in range(m):
        if graph[i][j]==1:
            queue = deque([[i,j]])
            graph[i][j]=0
            count=1
            while queue:
                # print(queue.popleft())
                x,y= queue.popleft()
                for k in range(4):
                    mx=dx[k]+x
                    my=dy[k]+y
                    if -1<mx<n and -1<my<m and graph[mx][my]==1:
                        graph[mx][my]=0
                        queue.append([mx,my])
                        count+=1
            max_count.append(count)
# print(graph)
if len(max_count)==0:
    print(0)
    print(0)
else:
    print(len(max_count))
    print(max(max_count))