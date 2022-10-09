import sys
from collections import deque
input = sys.stdin.readline

dx = [0,0,1,-1]
dy = [1,-1,0,0]

n,m = map(int,input().split())
graph = [list(input().strip()) for _ in range(m)]
visited = [[False]*n for _ in range(m)]

q = deque()
result =[0,0]
for i in range(m):
    for j in range(n):
        if visited[i][j]==False:
            visited[i][j]=True
            color = graph[i][j]
            q.appendleft([i,j])
            count = 1
            while q:
                y,x = q.pop()
                for k in range(4):
                    vy = y+dy[k]
                    vx = x+dx[k]
                    if -1<vy<m and -1<vx<n:
                        if visited[vy][vx]==True: continue
                        if graph[vy][vx]!=color: continue
                        visited[vy][vx]=True
                        count+=1
                        q.appendleft([vy,vx])
            if color=="W":
                result[0] += count*count
            else:
                result[1] += count*count
print(*result)