import sys

dx = [0,0,1,-1]
dy = [1,-1,0,0]
input= sys.stdin.readline

def dfs(x,y,count,sum):
    global result
    if result >= sum +max_val*(4-count):
        return
    if count == 4:
        result = max(result,sum)
    else:
        for i in range(4):
            vx = x+dx[i]
            vy = y+dy[i]
            if -1<vx<m and -1<vy<n and visited[vy][vx]==False:
                if count == 2:
                    visited[vy][vx]=True
                    dfs(x,y,count+1,sum+graph[vy][vx])
                    visited[vy][vx]=False
                visited[vy][vx]=True
                dfs(vx,vy,count+1,sum+graph[vy][vx])
                visited[vy][vx]=False

# def san(x,y):
#     temp = 0
#     if -1<y-1 and x+2<m: #ㅗ
#         temp=max(temp,graph[y-1][x+1]+graph[y][x]+graph[y][x+1]+graph[y][x+2])
#     if y+1<n and x+2<m: # ㅜ
#         temp = max(temp,graph[y+1][x+1]+graph[y][x]+graph[y][x+1]+graph[y][x+2])
#     if -1<x-1 and y+2<n: # ㅓ
#         temp=max(temp,graph[y+1][x-1]+graph[y][x]+graph[y+1][x]+graph[y+2][x])
#     if x+1<m and y+2<n: #ㅏ
#         temp=max(temp,graph[y+1][x+1]+graph[y][x]+graph[y+1][x]+graph[y+2][x])
#     return temp


n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
max_val = max(map(max, graph))
result = 0
for y in range(n):
    for x in range(m):
        visited[y][x]=True
        dfs(x,y,1,graph[y][x])
        visited[y][x]=False
        # result = max(result,san(x,y))
print(result)



