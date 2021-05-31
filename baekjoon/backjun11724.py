from collections import deque
from sys import stdin
# 3시 43분 시작 -> 3시 56분 끝
def bfs(graph,start,visit):
    queue= deque([start])
    visit[start]=True
    while queue:
        v=queue.popleft()
        for i in graph[v]:
            if not visit[i]:
                queue.append(i)
                visit[i]=True

N, M =list(map(int,stdin.readline().split()))
graph=[[] for i in range(N+1)]
visit=[False]*(N+1)

count=0
for _ in range(M):
    x,y=list(map(int,stdin.readline().split()))
    graph[x].append(y)
    graph[y].append(x)
# print(graph,visit)

for i in range(1,N+1):
    if not visit[i]:
        bfs(graph,i,visit)
        count+=1
print(count)