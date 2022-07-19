import sys
sys.setrecursionlimit(10000000)

input = sys.stdin.readline

def dfs(x,c):
    if result[0]==1:
        return
    if c==5:
        result[0]=1
        return
    for i in graph[x]:
        if visited[i]==False:
            visited[i]=True
            dfs(i,c+1)
            visited[i]=False

n,m = list(map(int,input().split()))
graph=[[] for _ in range(n)]
result=[0]
for _ in range(m):
    a,b = list(map(int,input().split()))
    graph[a].append(b)
    graph[b].append(a)

for i in range(n):
    visited =[False for _ in range(n)]
    visited[i]=True
    dfs(i,1)

print(*result)