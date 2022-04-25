import sys
from collections import deque
nx = [0,0,1,-1]
ny = [1,-1,0,0]
input= sys.stdin.readline

n = int(input())
graph=[]
result=[]
for i in range(n):
    temp=list(map(int,input().strip()))
    graph.append(temp)

for i in range(n):
    for j in range(n):
        if graph[i][j]==1:
            count=1
            graph[i][j]=0
            qeque = deque([[i,j]])
            while qeque:
                v = qeque.popleft()
                for k in range(4):
                    dx = v[0]+nx[k]
                    dy = v[1]+ny[k]
                    if 0<=dx<n and 0<=dy<n:
                        if graph[dx][dy]==1:
                            graph[dx][dy]=0
                            qeque.append([dx,dy])
                            count+=1
            result.append(count)
result.sort()
print(len(result))
for i in result:
    print(i)