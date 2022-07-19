from collections import deque
import sys
input = sys.stdin.readline

def BFS(graph,root):
    if root not in graph:
        return 1
    visited = [False]*(node+1) 
    queue=deque([root])
    visited[root]=True
    cnt=1
    while queue:
        n= queue.popleft()
        if n in graph:
            for i in graph[n]:
                if visited[i] is False:
                    visited[i]=True
                    cnt+=1
                    queue.append(i)
            
    return cnt

graph={}
node, edge=map(int,input().split(" "))

result=[]
max_cnt=0

for i in range(edge):
    n1,n2=map(int,input().split(" "))
    
    if n2 not in graph:
        graph[n2]=[n1]
    elif n1 not in graph[n2]:
        graph[n2].append(n1)

for start in range(1,node+1):
    cnt= BFS(graph,start)
    if cnt>max_cnt:
        max_cnt=cnt
    result.append([start,cnt])
# print(result)
for i,cnt in result:
    if max_cnt==cnt:
        print(i, end=" ")

