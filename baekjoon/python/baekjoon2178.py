# bfs

dx=[0,0,1,-1]
dy=[1,-1,0,0]

n,m = map(int,input().split(" "))

graph=[]
for i in range(n):
    graph.append(list(map(int, input())))

queue=[[0,0]]

while queue:
    x,y=queue[0][0],queue[0][1]
    del queue[0]
    for i in range(4):
        xn=x+dx[i]
        ym=y+dy[i]
        if xn>=0 and xn<n and ym>=0 and ym<m and graph[xn][ym]==1:
            queue.append([xn,ym])
            graph[xn][ym]=graph[x][y]+1


print(graph[n-1][m-1])