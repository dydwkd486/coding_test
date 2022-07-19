import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())

node = [[] for _ in range(n+1)]
parents = [0 for _ in range(n+1)]

for i in range(n-1):
    x,y=map(int,input().split())
    node[x].append(y)
    node[y].append(x)
# print(node)

def dfs(start):
    for i in node[start]:
        if parents[i]==0:
            parents[i]=start
            dfs(i)
dfs(1)

for i in range(2,n+1):
    print(parents[i])
