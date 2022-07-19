import sys
sys.setrecursionlimit(100000)

def dfs(x,y):
    if visited[x][y]!=True:
        visited[x][y]=True
        z = c-x-y
        if x==0:
            result.append(z)
        #x-> y
        water = min(x, b-y)
        dfs(x-water,y+water)
        #x-> z
        water = min(x, c-z)
        dfs(x-water,y)
        #y-> x
        water = min(y, a-x)
        dfs(x+water,y-water)
        #y-> z
        water = min(y, c-z)
        dfs(x,y-water)
        #z-> x
        water = min(z, a-x)
        dfs(x+water,y)
        #z-> y
        water = min(z, b-y)
        dfs(x,y+water)

input= sys.stdin.readline

a,b,c = list(map(int,input().split()))

visited=[[False]*(b+1) for _ in range(a+1)]

result =[]

dfs(0,0)
result.sort()
print(*result)

