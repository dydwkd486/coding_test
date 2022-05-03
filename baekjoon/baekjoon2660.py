import sys
from  collections import deque

input = sys.stdin.readline

n = int(input())

graph = [set() for _ in range(n+1)]

while True:
    x,y= map(int,input().split())
    if x==-1 and y == -1:
        break
    graph[x].add(y)
    graph[y].add(x)
result=[]
for j in range(1,n+1):
    queue= deque()
    visited=[False for _ in range(n+1)]
    for i in graph[j]:
        queue.append([i,0])
    visited[j]=True
    count=0
    while queue:
        v= queue.popleft()
        if visited[v[0]]==False:
            visited[v[0]]=True
            for i in graph[v[0]]:
                queue.append([i,v[1]+1])
        if count<v[1]:
            count=v[1]
    result.append(count)
result_min=min(result)
print(result_min,result.count(result_min))
for i in range(n):
    if result[i]==result_min:
        print(i+1,end=" ")
