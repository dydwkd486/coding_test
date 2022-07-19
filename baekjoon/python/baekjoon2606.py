from sys import stdin

def dfs(graph, v, visit):
    visit[v]=True
    # print(v,end=" ")
    for i in graph[v]:
        if not visit[i]:
            dfs(graph,i,visit)

N=int(stdin.readline())
M=int(stdin.readline())
graph=[]
visited=[False]*(N+1)

for i in range(N+1):
    line=[]
    graph.append(line)

for i in range(M):
    x,y=list(map(int,stdin.readline().split()))
    graph[x].append(y)
    graph[y].append(x)

for i in range(len(graph)):
    graph[i]=sorted(graph[i])
# print(graph)
# print(visited)
dfs(graph,1,visited)
print(len([i for i in visited if i==True])-1)


