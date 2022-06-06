import sys
sys.setrecursionlimit(10**9)

input= sys.stdin.readline

n = int(input())
n_list=[[] for _ in range(n+1)]
for i in range(n-1):
    a,b,c = map(int,input().split())
    n_list[a].append([b,c])
    n_list[b].append([a,c])

def dfs(x,y):
    for i in n_list[x]:
        p,v = i
        if visited[p]== -1:
            visited[p] = y+v
            dfs(p,y+v)

visited=[-1 for _ in range(n+1)]
visited[1]=0
dfs(1,0)

p= visited.index(max(visited))
visited=[-1 for _ in range(n+1)]
visited[p]=0
dfs(p,0)

print(max(visited))