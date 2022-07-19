import sys
from copy import deepcopy

def clar(x, y, dir):
    temp = deepcopy(graph)
    cx, cy = x, y - 1
    graph[x][y] = 0
    for i in range(4):
        while True:
            nx = x + dx[dir[i]]
            ny = y + dy[dir[i]]
            if nx == cx and ny == cy:
                return
            if 0 <= nx < r and 0 <= ny < c:
                graph[nx][ny] = temp[x][y]
            else:
                break
            x, y = nx, ny

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
input= sys.stdin.readline
# r행 , c열
r,c,t = map(int,input().split())
graph = []
cl=[]

for i in range(r):
    a = list(map(int, input().split()))
    graph.append(a)
    for j in range(c):
        if a[j] == -1:
            cl.append([i, j])
t1, t2 = cl[0][0], cl[0][1]
b1, b2 = cl[1][0], cl[1][1]


# 미세먼지 변화를 먼저 주기
# 현재와 미래를 나누어 볼 필요가 있을 것 같음.
for _ in range(t):
    graph_temp =[[0]*c for _ in range(r)]
    for y in range(r):
        for x in range(c):
            count = 0
            value = graph[y][x]//5
            # print(y,x,value)
            if graph[y][x]==-1:
                graph_temp[y][x]=-1
                continue
            if graph[y][x]==0:
                continue
            for i in range(4):
                vx = x+dx[i]
                vy = y+dy[i]
                if -1<vx<c and -1<vy<r and graph[vy][vx]!=-1:
                    count+=1
                    graph_temp[vy][vx]=graph_temp[vy][vx]+value
            graph_temp[y][x]+=graph[y][x] - value*count
    graph=graph_temp[::]
    # 이후 공기청정기 이동시키기
    # 공기청정기 위치 찾기
    clar(t1, t2 + 1, [3, 1, 2, 0])
    clar(b1, b2 + 1, [3, 0, 2, 1])

graph[t1][t2], graph[b1][b2] = 0, 0
result = 0
for i in graph:
    # print(i)
    result+=sum(i)
print(result)