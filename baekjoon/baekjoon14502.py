import sys
from collections import deque

dx=[0,0,1,-1]
dy=[1,-1,0,0]
n, m = map(int,sys.stdin.readline().split())

print(n,m)
graph=[]
for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split(" "))))
print(graph)

# 바이러스 위치 찾기
virus=[]
for i in range(n):
    for j in range(m):
        if graph[i][j]==2:
            virus.append([i,j])


# 벽세우기
for i in range()
print(virus)
