import sys
from collections import deque
input =sys.stdin.readline

F,S,G,U,D = list(map(int,input().split()))

n_list = [-1 for _ in range(F+1)]
visited=[False for _ in range(F+1)]

queue = deque([S])
n_list[S]=0
visited[S]=True

while queue:
    v= queue.popleft()
    if v+U<=F:
        if visited[v+U]==False:
            visited[v+U]=True
            queue.append(v+U)
            n_list[v+U]=n_list[v]+1
    if 0<v-D:
        if visited[v-D]==False:
            visited[v-D]=True
            queue.append(v-D) 
            n_list[v-D]=n_list[v]+1

if n_list[G]==-1:
    print("use the stairs")
else:
    print(n_list[G])
