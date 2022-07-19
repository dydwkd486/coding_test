import sys
from collections import deque 
input = sys.stdin.readline
'''
5 5
1 3
1 4
4 5
4 3
3 2
'''
def bfs(first):
   queue = deque([first]) 
   visited[first]=1

   while queue:
        
        v=queue.popleft()
        for i in graph[v]:
            if visited[i]==0:
                queue.append(i)
                visited[i]=visited[v]+1


n,m = list(map(int,input().split()))

graph= []
result=[]
for i in range(n+1):
    graph.append([])

for i in range(m):
    a,b = list(map(int,input().split()))
    graph[a].append(b)
    graph[b].append(a)
for i in range(1,n+1):
    graph[i]=list(set(graph[i]))

for i in range(1,n+1):
    visited=[1]+[0]*(n)
    bfs(i)
    # print(sum(visited)-len(visited))
    result.append(sum(visited)-len(visited))
# print(result)
print(result.index(min(result))+1)

