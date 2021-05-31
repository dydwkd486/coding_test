from sys import stdin
def bfs(x,y,visit):
    if x<=-1 or x>=N or y<=-1 or y>=M:
        return
    if visit[x][y]==0 and graph[x][y]==1:
        visit[x][y]=1
        for i in range(4):
            bfs(x-rx[i],y-ry[i],visit)

N,M = map(int,stdin.readline().split())
graph=[]
for i in range(N):
    graph.append(list(map(int, stdin.readline().split())))
rx=[0,0,1,-1]
ry=[1,-1,0,0]
result=0
for i in range(N):
    for j in range(M):
        if graph[i][j]==0:
            visit = [[0]*M for _ in range(N)]
            # print(visit)
            graph[i][j]=1
            # graph[i][j]=1
            # print(graph)
            bfs(i, j, visit)
            temp=0
            temp+=sum(sum(visit,[]))

            if result<temp:
                result=temp
            graph[i][j] = 0
print(result)