
import sys
dx = [0,0,1,-1]
dy = [1,-1,0,0]

input = sys.stdin.readline

graph = [list(input().strip()) for _ in range(12)]
visited =[[0]*6 for _ in range(12)]
result =0

def dfs(y,x):
    global count
    for i in range(4):
        vy = y+dy[i]
        vx = x+dx[i]
        
        if -1<vy<12 and -1<vx<6:
            if visited[vy][vx]==0 and graph[y][x]==graph[vy][vx]:
                count+=1
                visited[vy][vx]=count
                dfs(vy,vx) 

def check(y,x):
    for i in range(4):
        vy = y+dy[i]
        vx = x+dx[i]
        if -1<vy<12 and -1<vx<6:
            if visited[vy][vx]!=0 and graph[y][x]==graph[vy][vx]:
                visited[vy][vx]=0
                check(vy,vx)
                graph[vy][vx]="."
    

def fall(y,x):
    global graph
    graph_clone = [[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            graph_clone[i][j] = graph[i][j]
    vy = y
    vx = x
    for i in range(y,-1,-1):
        if graph[i][x] !=".": 
            graph_clone[vy][vx] = graph[i][x]
            vy-=1
    for i in range(vy,-1,-1):
        graph_clone[i][vx] = "."
    graph = graph_clone

        


while(True):
    visited =[[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if graph[i][j]=="." or visited[i][j]!=0: continue
            visited[i][j] = 1
            count = 1
            dfs(i,j)

    flag = False
    for i in range(12):
        for j in range(6):
            if visited[i][j]<4: continue
            visited[i][j] = 0
            check(i,j)
            graph[i][j]="."
            flag = True
    if not flag:
        break
    else:
        result+=1


    # 내려 보내기
    for i in range(6):
        for j in range(11,-1,-1):
            if graph[j][i] ==".":
                # 여기서 부터 위에 있는것을 내려야함.
                fall(j,i)
                break

    # for i in visited:
    #     print(i)
    # print()
    # for i in graph:
    #     print(i)


print(result)


